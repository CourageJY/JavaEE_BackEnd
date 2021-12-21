package com.pet.userManage.service;

import com.pet.models.FindApplication;
import com.pet.userManage.repository.FindApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindApplicationService {
    @Autowired
    FindApplicationRepository find;
    public List<FindApplication> findALLByUserID(String userID){
        return find.findAllByUserId(userID);
    }
}
