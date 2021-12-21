package com.pet.userManage.service;

import com.pet.models.ReportApplication;
import com.pet.userManage.repository.ReportApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportApplicationService {
    @Autowired
    ReportApplicationRepository report;
    public List<ReportApplication> findALLByUserID(String userID){
        return report.findAllByUserId(userID);
    }
}
