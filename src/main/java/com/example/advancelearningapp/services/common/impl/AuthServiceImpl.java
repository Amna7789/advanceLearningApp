package com.example.advancelearningapp.services.common.impl;

import com.example.advancelearningapp.config.LoggerAOP;
import com.example.advancelearningapp.services.IUserService;
import com.example.advancelearningapp.services.common.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;

@Service
public class AuthServiceImpl implements IAuthService {
    //IUserService use kia qk  isAdminUser uska method hai
    @Autowired
    IUserService userService;
    public Boolean isAdminUser(){
        HttpServletRequest request1 =
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String base64Auth = request1.getHeader("Authorization").substring(6);
        String credentials = new String(Base64.getDecoder().decode(base64Auth));
        String email = credentials.split(":")[0];
        String password = credentials.split(":")[1];
        //authentication or authorization  line
        Boolean validUser = userService.isAdminRole(email, password);

        return validUser;
    }
    public Boolean isAdminUserData(){
        HttpServletRequest request1 =
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String base64Auth = request1.getHeader("Authorization").substring(6);
        String credentials = new String(Base64.getDecoder().decode(base64Auth));
        String email = credentials.split(":")[0];
        String password = credentials.split(":")[1];
        String url = request1.getRequestURI();
       /* System.out.println(email);
        System.out.println(password);
        System.out.println(url);*/
        //authentication or authorization  line
        Boolean validUser = userService.isAdminRole(email, password);

        return validUser;
    }

    @Override
    public Boolean isStudentUser() {
        HttpServletRequest request1 =
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String base64Auth = request1.getHeader("Authorization").substring(6);
        String credentials = new String(Base64.getDecoder().decode(base64Auth));
        String email = credentials.split(":")[0];
        String password = credentials.split(":")[1];
        Boolean validUser = userService.isStudentRole(email, password);
        return validUser;
    }
}
