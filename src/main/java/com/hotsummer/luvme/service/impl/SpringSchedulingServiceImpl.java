package com.hotsummer.luvme.service.impl;

import com.hotsummer.luvme.model.entity.Routing;
import com.hotsummer.luvme.model.entity.UserTbl;
import com.hotsummer.luvme.repository.RoutingRepository;
import com.hotsummer.luvme.repository.UserTblRepository;
import com.hotsummer.luvme.service.SpringSchedulingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;


@Service
@Transactional
public class SpringSchedulingServiceImpl implements SpringSchedulingService {

    @Value("${spring.scheduled.env-key}")
    private String envKey;
    private ScheduledFuture<?> scheduledTask;
    private final Logger logger;
    private final RestTemplate restTemplate;
    private final TaskScheduler taskScheduler;
    private final RoutingRepository routingRepository;
    private final UserTblRepository userTblRepository;


    public SpringSchedulingServiceImpl(UserTblRepository userTblRepository, RestTemplate restTemplate, TaskScheduler taskScheduler, RoutingRepository routingRepository){
        this.userTblRepository = userTblRepository;
        this.restTemplate = restTemplate;
        this.taskScheduler = taskScheduler;
        this.routingRepository = routingRepository;
        this.logger = LoggerFactory.getLogger(SpringSchedulingServiceImpl.class);
    }
    @Scheduled(cron = "${spring.scheduled.cron-expression}")
    @Override
    public void setSchedule() {
        if (scheduledTask != null && !scheduledTask.isCancelled()) {
            scheduledTask.cancel(true);
            logger.info("Clear all user scheduling tasks");
        }

        List<UserTbl> userList = userTblRepository.findAll();
        int task = 0, doTask = 0;

        if(userList == null){
            logger.info("No user found no new scheduling task running");
            return;
        }
        for(UserTbl user : userList){
            task ++;
            Routing userRouting = routingRepository.findFirstByUserActUserIdOrderByDateDesc(user.getUserId());
            if(userRouting != null){
                int finalTask = task;
                taskScheduler.schedule(() -> performScheduledTask(user.getUserId(), finalTask), new CronTrigger(userRouting.getDateReminder()));
                logger.info("New scheduling task: [" + task + "] With user id: [" + user.getUserId() + "] Is running with cron expression is: " + userRouting.getDateReminder());
                doTask ++;
            }
        }
        if(doTask == 0){
            logger.info("No new task running, back to the system scheduling task");
        }
    }

    @Override
    public void performScheduledTask(int userId, int task){
        String apiUrl = "http://localhost:8080/api/v1/routing/create/scheduling/{envKey}/{userId}";

        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("envKey", envKey);
        uriVariables.put("userId", String.valueOf(userId));

        logger.info("Function running with envKey: [" + envKey + "] And user id: [" + userId + "]");
        try {
            ResponseEntity<String> responseEntity = restTemplate.exchange(
                    apiUrl,
                    HttpMethod.PUT,
                    null,
                    String.class,
                    uriVariables
            );

            logger.info("Task: [" + task + "] Response is: [" + responseEntity.getBody() + "]");
            if ("Success".equals(responseEntity.getBody())) {
                logger.info("Scheduling task [" + task + "] running success");
            } else {
                logger.info("Scheduling task [" + task + "] running error");
            }
        } catch (HttpClientErrorException e) {
            logger.error("Task: [" + task + "] Client error: " + e.getMessage());
        } catch (HttpServerErrorException e) {
            logger.error("Task: [" + task + "] Server error: " + e.getMessage());
        }
    }
}
