package com.example.advancelearningapp.services;

import com.example.advancelearningapp.domain.StudentCourseRelationDTO;
import com.example.advancelearningapp.domain.StudentDTO;
import com.example.advancelearningapp.domain.inboud.StudentDTOIn;

public interface IStudentService {
    public StudentDTO createNewStudent(StudentDTOIn studentDTOIn);

   public StudentCourseRelationDTO enrollStudent(StudentCourseRelationDTO studentCourseRelationDTO);
}
