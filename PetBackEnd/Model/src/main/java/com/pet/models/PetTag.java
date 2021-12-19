package com.pet.models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "pet_tag")
@Entity
public class PetTag {
    @EmbeddedId
    private PetTagId id;

    public PetTagId getId() {
        return id;
    }

    public void setId(PetTagId id) {
        this.id = id;
    }
}