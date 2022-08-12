package com.example.advancelearningapp.controller;

import com.example.advancelearningapp.controller.annotation.Verification;
import com.example.advancelearningapp.domain.StudentCourseRelationDTO;
import com.example.advancelearningapp.domain.StudentDTO;
import com.example.advancelearningapp.domain.inboud.StudentDTOIn;
import com.example.advancelearningapp.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @Autowired
    IStudentService studentService;

    @ResponseStatus(HttpStatus.CREATED)
    @Verification(role = "STUDENT")
    @PostMapping("/student")
    public StudentDTO createStudent(@RequestBody StudentDTOIn studentDTOIn){
        return studentService.createNewStudent(studentDTOIn);

    }
    @ResponseStatus(HttpStatus.CREATED)
    @Verification(role = "STUDENT")
    @PostMapping("/student/enrollStudent/Course")
    public StudentCourseRelationDTO enrollStudentCourse(@RequestBody StudentCourseRelationDTO studentCourseRelationDTO){
        return studentService.enrollStudent(studentCourseRelationDTO);

    }

}
