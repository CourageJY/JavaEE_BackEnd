package com.pet.models;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PetTagId implements Serializable {
    private static final long serialVersionUID = -8698965900824156001L;
    @Column(name = "pet_ID", nullable = false, length = 10)
    private String petId;
    @Column(name = "tag", nullable = false, length = 8)
    private String tag;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getPetId() {
        return petId;
    }

    public void setPetId(String petId) {
        this.petId = petId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(petId, tag);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PetTagId entity = (PetTagId) o;
        return Objects.equals(this.petId, entity.petId) &&
                Objects.equals(this.tag, entity.tag);
    }
}