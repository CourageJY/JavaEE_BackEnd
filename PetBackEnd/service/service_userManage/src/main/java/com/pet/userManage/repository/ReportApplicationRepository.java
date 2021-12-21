package com.pet.userManage.repository;

import com.pet.models.ReportApplication;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReportApplicationRepository extends CrudRepository<ReportApplication,String>{
    List<ReportApplication> findAllByUserId(String userID);
}
