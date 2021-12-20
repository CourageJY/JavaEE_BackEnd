package com.pet.petManage.service;

import com.pet.models.Pet;
import com.pet.petManage.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PetDetailService {
    @Autowired
    PetRepository petRepository;
    public Pet getById(String petID)
    {
        Optional<Pet> pet=petRepository.findById(petID);
        return pet.orElse(null);
    }
}
