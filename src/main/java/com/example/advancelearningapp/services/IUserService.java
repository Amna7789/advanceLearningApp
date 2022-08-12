package com.example.advancelearningapp.services;

import com.example.advancelearningapp.domain.LoginDTO;
import com.example.advancelearningapp.domain.inboud.LoginDTOIn;

public interface IUserService {
   public LoginDTO checkLogin(LoginDTOIn loginDTOIn);
   public Boolean isValidUser(String email, String password);

   public Boolean isAdminRole(String email, String password);
   public Boolean isStudentRole(String email, String password);
}
