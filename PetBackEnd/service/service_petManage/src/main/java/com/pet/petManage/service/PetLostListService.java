package com.pet.petManage.service;

import com.pet.models.Pet;
import com.pet.petManage.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetLostListService {
    @Autowired
    PetRepository petRepository;

    public List<Pet> findByAdoptState() {
        return petRepository.findAllByAdoptState("待寻回");
    }
}
