package com.pet.petManage.repository;

import com.pet.models.Pet;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PetRepository extends CrudRepository<Pet,String> {
    List<Pet> findAllByAdoptState(String s);
}
