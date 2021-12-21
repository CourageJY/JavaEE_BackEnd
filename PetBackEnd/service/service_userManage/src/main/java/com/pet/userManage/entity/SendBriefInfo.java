package com.pet.userManage.entity;

import com.pet.models.SendApplication;

import java.time.Instant;

public class SendBriefInfo {
    public String title;
    public Instant time;
    public String status;

    public SendBriefInfo(SendApplication sendApplication){
        title = sendApplication.getTitle();
        time = sendApplication.getTime();
        status = sendApplication.getStatus();
    }
}
