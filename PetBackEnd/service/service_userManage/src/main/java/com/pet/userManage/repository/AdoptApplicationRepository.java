package com.pet.userManage.repository;

import com.pet.models.AdoptApplication;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AdoptApplicationRepository extends CrudRepository<AdoptApplication,String> {
    List<AdoptApplication> findAllByUserId(String userID);
}