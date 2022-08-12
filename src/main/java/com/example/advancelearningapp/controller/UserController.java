package com.example.advancelearningapp.controller;

import com.example.advancelearningapp.domain.LoginDTO;
import com.example.advancelearningapp.domain.inboud.LoginDTOIn;
import com.example.advancelearningapp.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {
    @Autowired
    IUserService userService;

    @GetMapping("/login")
    public LoginDTO login(@Valid @RequestBody LoginDTOIn loginDTOIn){
        //controller ko rush nhi karna
       /* if(loginDTOIn.getEmail()== null || loginDTOIn.getEmail().isEmpty())
            throw new IllegalArgumentException("");
        if(loginDTOIn.getPassword()== null || loginDTOIn.getPassword().isEmpty())
            throw new IllegalArgumentException("");*/
        return userService.checkLogin(loginDTOIn);
    }
}
