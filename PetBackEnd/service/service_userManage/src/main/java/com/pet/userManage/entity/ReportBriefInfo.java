package com.pet.userManage.entity;

import com.pet.models.ReportApplication;

import java.time.Instant;

public class ReportBriefInfo {
    public String title;
    public Instant reportTime;
    public String status;

    public ReportBriefInfo(ReportApplication reportApplication){
        title = reportApplication.getTitle();
        reportTime = reportApplication.getReportTime();
        status = reportApplication.getStatus();
    }
}
