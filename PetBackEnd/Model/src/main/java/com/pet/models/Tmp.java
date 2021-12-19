package com.pet.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tmp")
@Entity
public class Tmp {
    @Id
    @Column(name = "id", nullable = false, length = 2)
    private String id;

    @Column(name = "name", length = 10)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}