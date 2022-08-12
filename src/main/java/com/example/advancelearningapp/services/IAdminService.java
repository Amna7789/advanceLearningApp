package com.example.advancelearningapp.services;

import com.example.advancelearningapp.domain.AdminDTO;
import com.example.advancelearningapp.domain.inboud.AdminDTOIn;

public interface IAdminService {
    public AdminDTO createNewAdmin(AdminDTOIn adminDTOIn);
}
