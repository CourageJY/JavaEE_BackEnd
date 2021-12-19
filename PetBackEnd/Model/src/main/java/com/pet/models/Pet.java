package com.pet.models;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "pet")
@Entity
public class Pet {
    @Id
    @Column(name = "pet_ID", nullable = false, length = 10)
    private String id;

    @Column(name = "name", length = 20)
    private String name;

    @Column(name = "type", length = 10)
    private String type;

    @Column(name = "time")
    private LocalDate time;

    @ManyToOne
    @JoinColumn(name = "adopt_user")
    private User adoptUser;

    @Column(name = "adopt_time")
    private LocalDate adoptTime;

    @Column(name = "age")
    private Integer age;

    @Column(name = "sex")
    private Boolean sex;

    @Column(name = "color", length = 10)
    private String color;

    @Column(name = "description", length = 100)
    private String description;

    @Column(name = "adopt_state", length = 6)
    private String adoptState;

    @Column(name = "photo", length = 100)
    private String photo;

    @Column(name = "area", length = 40)
    private String area;

    public Pet(String id, String name, String type, LocalDate time, User adoptUser, LocalDate adoptTime, Integer age, Boolean sex, String color, String description, String adoptState, String photo, String area) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.time = time;
        this.adoptUser = adoptUser;
        this.adoptTime = adoptTime;
        this.age = age;
        this.sex = sex;
        this.color = color;
        this.description = description;
        this.adoptState = adoptState;
        this.photo = photo;
        this.area = area;
    }

    public Pet(String name, String type, Integer age, Boolean sex, String color, String description, String photo, String area) {
        this.name = name;
        this.type = type;
        this.age = age;
        this.sex = sex;
        this.color = color;
        this.description = description;
        this.photo = photo;
        this.area = area;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAdoptState() {
        return adoptState;
    }

    public void setAdoptState(String adoptState) {
        this.adoptState = adoptState;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getAdoptTime() {
        return adoptTime;
    }

    public void setAdoptTime(LocalDate adoptTime) {
        this.adoptTime = adoptTime;
    }

    public User getAdoptUser() {
        return adoptUser;
    }

    public void setAdoptUser(User adoptUser) {
        this.adoptUser = adoptUser;
    }

    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

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