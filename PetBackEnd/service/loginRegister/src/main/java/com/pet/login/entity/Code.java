package com.pet.login.entity;

import java.util.Date;

public class Code {
    public String code;//六位验证码
    public Date time;//验证码的时间

    public Code(String code){
        this.code=code;
        this.time=new Date();
    }
}
