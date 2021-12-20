package com.pet.login.repository;

import com.pet.models.InstitutionWorker;
import org.springframework.data.repository.CrudRepository;

public interface InstitutionRepository extends CrudRepository<InstitutionWorker,String> {
}
