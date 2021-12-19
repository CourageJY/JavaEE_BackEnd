package com.pet.util.error;

public class UserNotExistedError implements ServiceError{
    @Override
    public String getMessage(){return "User is not existed";}

    @Override
    public Integer getCode(){return -1;}
}
