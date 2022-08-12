package com.example.advancelearningapp.controller;

import com.example.advancelearningapp.domain.AdminDTO;
import com.example.advancelearningapp.domain.inboud.AdminDTOIn;
import com.example.advancelearningapp.services.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @Autowired
    IAdminService adminService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/admin/createAdmin")
    public AdminDTO createAdmin(@RequestBody AdminDTOIn adminDTOIn){
        return adminService.createNewAdmin(adminDTOIn);
    }
}
