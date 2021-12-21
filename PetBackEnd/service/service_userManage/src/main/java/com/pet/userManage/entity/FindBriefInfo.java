package com.pet.userManage.entity;

import com.pet.models.FindApplication;

import java.time.Instant;

public class FindBriefInfo {
    public String title;
    public Instant applyTime;
    public String status;

    public FindBriefInfo(FindApplication findApplication){
        title = findApplication.getTitle();
        applyTime = findApplication.getApplyTime();
        status = findApplication.getStatus();
    }

}
