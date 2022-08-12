package com.example.advancelearningapp.domain;

import com.example.advancelearningapp.domain.inboud.StudentDTOIn;

public class StudentDTO extends StudentDTOIn {
    String studentId;
    public StudentDTO() {
    }

    public StudentDTO(String studentId ,String name, String email, String phoneNo, String password) {
        super(name, email, phoneNo, password);
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
}
