package com.pet.util.utils;

import com.pet.util.error.ServiceError;

import java.io.Serializable;
import java.util.Date;

public class Result<T> implements Serializable {
    private Date timestamp;

    private T data;

    private boolean success;

    private String message;

    private Integer code;

    public Result() {
    }

    //成功结果
    public static <T> Result<T> wrapSuccessfulResult(T data) {
        Result<T> result = new Result<T>();
        result.data = data;
        result.success = true;
        result.code=0;
        result.timestamp=new Date();
        return result;
    }

    //重载成功结果
    public static <T> Result<T> wrapSuccessfulResult(String message, T data) {
        Result<T> result = new Result<T>();
        result.data = data;
        result.success = true;
        result.message = message;
        result.code=0;
        result.timestamp=new Date();
        return result;
    }

    //成功（只需返回message)
    public static <T> Result<T> wrapSuccessfulResult(String message) {
        Result<T> result = new Result<T>();
        result.success = true;
        result.message = message;
        result.code=0;
        result.timestamp=new Date();
        return result;
    }

    //错误
    public static <T> Result<T> wrapErrorResult(ServiceError error) {
        Result<T> result = new Result<T>();
        result.success = false;
        result.message = error.getMessage();
        result.code=error.getCode();
        result.timestamp=new Date();
        return result;
    }

    //重载错误
    public static <T> Result<T> wrapErrorResult(ServiceError error, Object... extendMsg) {
        Result<T> result = new Result<T>();
        result.success = false;
        result.message = String.format(error.getMessage(), extendMsg);
        result.code= error.getCode();
        result.timestamp=new Date();
        return result;
    }

    //重载错误
    public static <T> Result<T> wrapErrorResult(String message) {
        Result<T> result = new Result<T>();
        result.success = false;
        result.message = message;
        result.timestamp=new Date();
        return result;
    }

    public T getData() {
        return this.data;
    }

    public Result<T> setData(T data) {
        this.data = data;
        return this;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public Result<T> setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public String getMessage() {
        return this.message;
    }

    public Result<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
