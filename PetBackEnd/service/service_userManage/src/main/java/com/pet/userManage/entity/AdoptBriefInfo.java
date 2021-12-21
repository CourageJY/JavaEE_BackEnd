package com.pet.userManage.entity;

import com.pet.models.AdoptApplication;
import com.pet.models.Pet;

import java.time.Instant;

public class AdoptBriefInfo {
    public String title;
    public Instant adoptTime;
    public Pet pet;
    public String status;

    public AdoptBriefInfo(AdoptApplication adoptApplication){
        title = adoptApplication.getTitle();
        adoptTime = adoptApplication.getAdoptTime();
        pet = adoptApplication.getPet();
        status = adoptApplication.getStatus();
    }
}
