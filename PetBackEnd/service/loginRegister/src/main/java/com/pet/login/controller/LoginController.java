package com.pet.login.controller;

import com.pet.login.service.InstitutionService;
import com.pet.login.service.UserService;
import com.pet.models.InstitutionWorker;
import com.pet.models.User;
import com.pet.util.utils.Encryption;
import com.pet.util.utils.JwtUtil;
import com.pet.util.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
@RefreshScope
@Api(value="login",tags = "登录")
public class LoginController {
    @Autowired
    private UserService userService;

    @Autowired
    private InstitutionService institutionService;

    @ApiOperation(value="用户登录")
    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public Result<String> userLogin(@RequestParam("userID") String userID, @RequestParam("pwd") String pwd)
    {
        User user=userService.getById(userID);
        if(user==null){
            return Result.wrapErrorResult("不存在该用户名！");
        }
        if(!user.getPassword().equals(Encryption.shiroEncryption(pwd,user.getSalt()))){
            return Result.wrapErrorResult("密码错误！");
        }
        //产生token
        String token= JwtUtil.getToken(user);
        return Result.wrapSuccessfulResult("登录成功",token);
    }

    @ApiOperation(value = "机构登录")
    @RequestMapping(value = "/institution", method = RequestMethod.POST)
    public Result<String> institutionLogin(@RequestParam("institutionID") String institutionID
            , @RequestParam("pwd") String pwd) {
        InstitutionWorker institution=institutionService.getById(institutionID);
        if(institution==null){
            return Result.wrapErrorResult("不存在该用户名！");
        }
        if(!institution.getPassword().equals(Encryption.shiroEncryption(pwd,institution.getSalt()))){
            return Result.wrapErrorResult("密码错误！");
        }
        //产生token
        String token= JwtUtil.getToken(institution);
        return Result.wrapSuccessfulResult("登录成功",token);
    }
}
