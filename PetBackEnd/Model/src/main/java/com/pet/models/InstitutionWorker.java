package com.pet.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "institution_worker")
@Entity
public class InstitutionWorker {
    @Id
    @Column(name = "worker_id", nullable = false, length = 10)
    private String id;

    @Column(name = "name", length = 20)
    private String name;

    @Column(name = "avatar", length = 30)
    private String avatar;

    @Column(name = "phone", length = 11)
    private String phone;

    @Column(name = "password", length = 32)
    private String password;

    @Column(name = "salt", length = 24)
    private String salt;

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
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