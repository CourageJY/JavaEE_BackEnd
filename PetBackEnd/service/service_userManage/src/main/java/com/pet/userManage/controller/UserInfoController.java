package com.pet.userManage.controller;

import com.pet.models.User;
import com.pet.userManage.entity.UserInfo;
import com.pet.userManage.service.UserService;
import com.pet.util.utils.Encryption;
import com.pet.util.utils.JwtUtil;
import com.pet.util.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


@RestController
@RequestMapping("api/user")
@RefreshScope
@Api(value="manage_user",tags = "管理用户信息")
public class UserInfoController {

    private UserService userService;
    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }

    @ApiOperation(value = "删除用户")
    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public Result<String> DeleteUser(HttpServletRequest httpServletRequest){
        String userID = JwtUtil.getIDByToken(httpServletRequest);
        Boolean successful = userService.deleteById(userID);
        if(!successful){
            return Result.wrapErrorResult("Error!");
        }
        return Result.wrapSuccessfulResult("Success!");
    }

    @ApiOperation(value = "查询用户的详细信息")
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public Result<User> UserDetail(HttpServletRequest httpServletRequest){
        String userID = JwtUtil.getIDByToken(httpServletRequest);
        User user = userService.getById(userID);
        if(user==null){
            return Result.wrapErrorResult("database error");
        }
        return Result.wrapSuccessfulResult(user);
    }

    @ApiOperation(value = "修改用户的详细信息")
    @RequestMapping(value = "/modify",method = RequestMethod.POST)
    public Result<String> ModifyUser(@RequestBody UserInfo info, HttpServletRequest httpServletRequest) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ClassNotFoundException {
        String userID = JwtUtil.getIDByToken(httpServletRequest);
        User sessionUser = userService.getById(userID);
        Field[] field = info.getClass().getDeclaredFields();
        for (Field value : field) {
            String name = value.getName();
            if (name.equals("id") || name.equals("password") || name.equals("credits")) {
                continue;
            }
            name = name.substring(0, 1).toUpperCase() + name.substring(1);
            Method get = info.getClass().getMethod("get" + name);
            String type = value.getGenericType().toString().substring(6);
            Method set = sessionUser.getClass().getMethod("set" + name, Class.forName(type));
            if (get.invoke(info) != null) {
                set.invoke(sessionUser, get.invoke(info));
            }
        }
        userService.modifyById(sessionUser);
        return Result.wrapSuccessfulResult("Success!");
    }

    @ApiOperation(value = "修改用户的详细信息")
    @RequestMapping(value = "/modify/password",method = RequestMethod.POST)
    public Result<String> ModifyPassword(@RequestParam("oldPassword") String oldPwd,
                                 @RequestParam("newPassword") String newPwd,
                                 HttpServletRequest httpServletRequest){
        String userID = JwtUtil.getIDByToken(httpServletRequest);
        User user=userService.getById(userID);
        if(!user.getPassword().equals(Encryption.shiroEncryption(oldPwd,user.getSalt()))){
            return Result.wrapErrorResult("密码错误！");
        }
        user.setPassword(Encryption.shiroEncryption(newPwd,user.getSalt()));
        userService.modifyById(user);
        return Result.wrapSuccessfulResult("Success!");
    }
}
