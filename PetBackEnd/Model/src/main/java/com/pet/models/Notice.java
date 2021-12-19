package com.pet.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

@Table(name = "notice")
@Entity
public class Notice {
    @Id
    @Column(name = "ID", nullable = false, length = 10)
    private String id;

    @Column(name = "image", length = 30)
    private String image;

    @Column(name = "context")
    private String context;

    @Column(name = "time")
    private Instant time;

    public Instant getTime() {
        return time;
    }

    public void setTime(Instant time) {
        this.time = time;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}