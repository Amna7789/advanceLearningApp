package com.example.advancelearningapp.domain;

import com.example.advancelearningapp.domain.inboud.AdminDTOIn;

public class AdminDTO extends AdminDTOIn {
    String id;

    public AdminDTO() {
    }

    public AdminDTO(String id, String name, String email, String password,String phoneNo) {
        super(name, email, password, phoneNo);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
