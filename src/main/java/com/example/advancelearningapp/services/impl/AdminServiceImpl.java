package com.example.advancelearningapp.services.impl;

import com.example.advancelearningapp.datamodel.User;
import com.example.advancelearningapp.datamodel.repo.UserRepo;
import com.example.advancelearningapp.domain.AdminDTO;
import com.example.advancelearningapp.domain.inboud.AdminDTOIn;
import com.example.advancelearningapp.services.IAdminService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements IAdminService {
    @Autowired
    UserRepo userRepo;
    @Override
    public AdminDTO createNewAdmin(AdminDTOIn adminDTOIn) {
        ModelMapper mp = new ModelMapper();
        User user= mp.map(adminDTOIn, User.class);
        user.setRole("ADMIN");
        user = userRepo.save(user);
        AdminDTO adminDTO =mp.map(user, AdminDTO.class);
        return adminDTO;
    }
}
