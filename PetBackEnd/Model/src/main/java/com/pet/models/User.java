package com.pet.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "user")
@Entity
public class User {
    @Id
    @Column(name = "user_ID", nullable = false, length = 10)
    private String id;

    @Column(name = "name", length = 20)
    private String name;

    @Column(name = "gender", length = 4)
    private String gender;

    @Column(name = "password", length = 32)
    private String password;

    @Column(name = "phone_number", length = 11)
    private String phoneNumber;

    @Column(name = "email", length = 30)
    private String email;

    @Column(name = "profile", length = 30)
    private String profile;

    @Column(name = "avatar", length = 30)
    private String avatar;

    @Column(name = "credits")
    private Integer credits;

    @Column(name = "salt", length = 24)
    private String salt;

    @Column(name = "open_ID", length = 30)
    private String openId;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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