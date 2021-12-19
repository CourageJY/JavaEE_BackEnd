package com.pet.models;

import javax.persistence.*;
import java.time.Instant;

@Table(name = "find_application", indexes = {
        @Index(name = "user_ID", columnList = "user_ID"),
        @Index(name = "pet_ID", columnList = "pet_ID")
})
@Entity
public class FindApplication {
    @Id
    @Column(name = "application_ID", nullable = false, length = 10)
    private String id;

    @ManyToOne
    @JoinColumn(name = "user_ID")
    private User user;

    @Column(name = "title", length = 20)
    private String title;

    @Column(name = "apply_time")
    private Instant applyTime;

    @ManyToOne
    @JoinColumn(name = "pet_ID")
    private Pet pet;

    @Column(name = "description", length = 100)
    private String description;

    @Column(name = "pet_photo", length = 30)
    private String petPhoto;

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

    public String getPetPhoto() {
        return petPhoto;
    }

    public void setPetPhoto(String petPhoto) {
        this.petPhoto = petPhoto;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Instant getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Instant applyTime) {
        this.applyTime = applyTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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