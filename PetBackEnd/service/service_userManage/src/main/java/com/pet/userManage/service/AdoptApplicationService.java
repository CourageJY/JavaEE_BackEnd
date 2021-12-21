package com.pet.userManage.service;

import com.pet.models.AdoptApplication;
import com.pet.userManage.repository.AdoptApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdoptApplicationService {
    @Autowired
    AdoptApplicationRepository adopt;
    public List<AdoptApplication>findALLByUserID(String userID){
        return adopt.findAllByUserId(userID);
    }
}
