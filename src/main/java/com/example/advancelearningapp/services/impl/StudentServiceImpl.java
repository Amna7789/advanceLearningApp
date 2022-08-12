package com.example.advancelearningapp.services.impl;

import com.example.advancelearningapp.datamodel.StudentCourseRelation;
import com.example.advancelearningapp.datamodel.User;
import com.example.advancelearningapp.datamodel.repo.StudentCourseRelationRepo;
import com.example.advancelearningapp.datamodel.repo.UserRepo;
import com.example.advancelearningapp.domain.StudentCourseRelationDTO;
import com.example.advancelearningapp.domain.StudentDTO;
import com.example.advancelearningapp.domain.inboud.StudentDTOIn;
import com.example.advancelearningapp.services.IStudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    UserRepo studentRepo;
    @Autowired
    StudentCourseRelationRepo studentCourseRelationRepo;

    @Override
    public StudentDTO createNewStudent(StudentDTOIn studentDTOIn) {
        ModelMapper mp = new ModelMapper();
        User user = mp.map(studentDTOIn, User.class);
        user.setRole("STUDENT");
        user = studentRepo.save(user);
        StudentDTO studentDTO =mp.map(user,StudentDTO.class);
        return studentDTO;
    }

    @Override
    public StudentCourseRelationDTO enrollStudent(StudentCourseRelationDTO studentCourseRelationDTO) {
        ModelMapper mp = new ModelMapper();
        StudentCourseRelation scr = mp.map(studentCourseRelationDTO, StudentCourseRelation.class);
        scr = studentCourseRelationRepo.save(scr);
        StudentCourseRelationDTO scrd =mp.map(scr,StudentCourseRelationDTO.class);
        return scrd;
    }
}
