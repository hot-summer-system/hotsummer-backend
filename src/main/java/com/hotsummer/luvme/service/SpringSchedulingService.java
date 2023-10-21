package com.hotsummer.luvme.service;

public interface SpringSchedulingService {
    void setSchedule();
    void performScheduledTask(int userId, int task);
}
