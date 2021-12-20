package com.pet.login.service;

import com.pet.login.repository.InstitutionRepository;
import com.pet.models.InstitutionWorker;
import com.pet.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InstitutionService {
    @Autowired
    InstitutionRepository institution;

    public InstitutionWorker getById(String institutionID)
    {
        Optional<InstitutionWorker> i=institution.findById(institutionID);
        return i.orElse(null);
    }


}
