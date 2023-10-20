package com.hotsummer.luvme.model.mapper;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

public  class TimeConverter {
    public static Date getCurrentDate(){
        LocalDateTime currentDateTime = LocalDateTime.now();
        return Timestamp.valueOf(currentDateTime);
    }

    public static String getCronExpression(String time){
        String[] parts = null;
        if(time.contains(":")){
            parts = time.split(":");
        }
        if(time.contains("-")){
            parts = time.split("-");
        }
        if(time.contains("/")){
            parts = time.split("/");
        }
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1].substring(0, 2));
        return  String.format("0 %02d %02d * * ?", minutes, hours);
    }
}
