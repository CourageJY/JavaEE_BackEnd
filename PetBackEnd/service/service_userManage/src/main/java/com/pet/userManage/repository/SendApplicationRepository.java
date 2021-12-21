package com.pet.userManage.repository;

import com.pet.models.SendApplication;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SendApplicationRepository extends CrudRepository<SendApplication,String> {
    List<SendApplication> findAllByUserId(String userID);
}
