package com.pet.userManage.service;

import com.pet.models.SendApplication;
import com.pet.userManage.repository.SendApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SendApplicationService {
    @Autowired
    SendApplicationRepository send;
    public List<SendApplication> findALLByUserID(String userID){
        return send.findAllByUserId(userID);
    }
}
