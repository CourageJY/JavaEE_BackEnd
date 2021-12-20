package com.pet.petManage.entity;


public class BriefPetInfoReturn {
    public String name;
    public String type;
    public int age;
    public String photo;
    public BriefPetInfoReturn()
    {
        age=0;
        name=null;
        type=null;
        photo=null;
    }

    public BriefPetInfoReturn(String name, String type, int age, String photo)
    {
        this.age=age;
        this.name=name;
        this.type=type;
        this.photo=photo;
    }
}
