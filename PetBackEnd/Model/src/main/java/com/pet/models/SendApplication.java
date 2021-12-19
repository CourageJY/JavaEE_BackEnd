package com.pet.models;

import javax.persistence.*;
import java.time.Instant;

@Table(name = "send_application", indexes = {
        @Index(name = "user_ID", columnList = "user_ID"),
        @Index(name = "pet_ID", columnList = "pet_ID")
})
@Entity
public class SendApplication {
    @Id
    @Column(name = "application_ID", nullable = false, length = 10)
    private String id;

    @ManyToOne
    @JoinColumn(name = "user_ID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "pet_ID")
    private Pet pet;

    @Column(name = "title", length = 20)
    private String title;

    @Column(name = "time")
    private Instant time;

    @Column(name = "location", length = 30)
    private String location;

    @Column(name = "reason", length = 100)
    private String reason;

    @Column(name = "photo", length = 30)
    private String photo;

    @Column(name = "status", length = 6)
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Instant getTime() {
        return time;
    }

    public void setTime(Instant time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}