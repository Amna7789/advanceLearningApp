package com.example.advancelearningapp.services.impl;

import com.example.advancelearningapp.datamodel.User;
import com.example.advancelearningapp.datamodel.repo.UserRepo;
import com.example.advancelearningapp.domain.LoginDTO;
import com.example.advancelearningapp.domain.inboud.LoginDTOIn;
import com.example.advancelearningapp.services.IUserService;
import com.example.advancelearningapp.shared.GenericModelMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    UserRepo userRepo;
    @Override
    public LoginDTO checkLogin(LoginDTOIn loginDTOIn) {

        User user = userRepo.findByEmailAndPassword(loginDTOIn.getEmail(),loginDTOIn.getPassword());
        LoginDTO loginDTO = GenericModelMapper.map(loginDTOIn,LoginDTO.class);
        loginDTO.setLogin(false);
        if(user != null){
            loginDTO.setLogin(true);
        }
        return loginDTO;

    }
    //authentication
    public Boolean isValidUser(String email, String password) {

        User user = userRepo.findByEmailAndPassword(email,password);
        if(user != null){
            return true;
        }
        return false;
    }
    //authorization
    public Boolean isAdminRole(String email, String password) {

        User user = userRepo.findByEmailAndPassword(email,password);
        if(user == null){
            return false;
        }
        if("ADMIN".equalsIgnoreCase(user.getRole())){
            return true;
        }
        return false;
    }

    @Override
    public Boolean isStudentRole(String email, String password) {
        User user = userRepo.findByEmailAndPassword(email, password);
        if(user == null)
            return false;
        if("STUDENT".equalsIgnoreCase(user.getRole()))
            return true;
        return false;
    }
}
