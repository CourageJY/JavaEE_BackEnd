package com.pet.login.controller;

import com.pet.login.entity.Code;
import com.pet.login.entity.RegisterInfo;
import com.pet.login.service.EmailService;
import com.pet.login.service.UserService;
import com.pet.models.User;
import com.pet.util.utils.Encryption;
import com.pet.util.utils.Radom;
import com.pet.util.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/register")
@RefreshScope
@Api(value="register",tags = "注册")
public class RegisterController {
    @Autowired
    private UserService userService;

    @Autowired
    EmailService emailService;

    private Map<String, Code> map=new HashMap<>();//用于暂存验证码(后面可存入redis中)

    private long outDate= 300000L;

    @ApiOperation(value="用户注册")
    @RequestMapping(value = "/signIn",method = RequestMethod.POST)
    public Result<String> register(@RequestBody RegisterInfo info){
        if(userService.getById(info.ID)!=null){
            return Result.wrapErrorResult("用户名已存在！");
        }

        Date time=new Date();
        if(time.getTime()-map.get(info.email).time.getTime()>=outDate){
            return Result.wrapErrorResult("验证码过期，请重新获取");
        }

        if(!Objects.equals(map.get(info.email).code, info.code)){
            return Result.wrapErrorResult("验证码错误！");
        }

        User user=new User();
        user.setId(info.ID);
        user.setEmail(info.email);
        user.setName(info.name);
        user.setPhoneNumber(info.phone);
        user.setSalt(Encryption.generateSalt());
        user.setPassword(Encryption.shiroEncryption(info.pwd,user.getSalt()));
        user.setCredits(100);
        user.setGender(info.gender);
        //存储
        userService.create(user);

        return Result.wrapSuccessfulResult("注册成功");
    }

    @ApiOperation(value="验证码发送")
    @RequestMapping(value = "/getCode",method = RequestMethod.GET)
    public Result<String> getCode(@RequestParam("email") String email){
        String code= Radom.getSixBitRandom();//获取六位随机验证码
        //邮件发送接口
        try{
            emailService.sendMimeMail(email,map,code);
        }catch (Exception e){
            return Result.wrapErrorResult(e.getMessage());
        }

        return Result.wrapSuccessfulResult("发送成功");
    }
}

