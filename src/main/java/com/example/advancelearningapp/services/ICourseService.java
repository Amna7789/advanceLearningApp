package com.example.advancelearningapp.services;

import com.example.advancelearningapp.domain.CourseDTO;
import com.example.advancelearningapp.domain.inboud.CourseDTOIn;

import java.util.List;

public interface ICourseService {
   public CourseDTO createCourse(CourseDTOIn courseDTOIn);

   public void updateCourse(String courseId, CourseDTOIn courseDTOIn);

   public  void deleteCourse(String courseId);

   public List<CourseDTO> getCourses();
}
