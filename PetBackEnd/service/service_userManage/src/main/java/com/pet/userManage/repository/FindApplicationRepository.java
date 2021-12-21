package com.pet.userManage.repository;
import com.pet.models.FindApplication;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FindApplicationRepository extends CrudRepository<FindApplication,String> {
    List<FindApplication> findAllByUserId(String userID);
}