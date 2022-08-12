package com.example.advancelearningapp.services.impl;

import com.example.advancelearningapp.datamodel.Course;
import com.example.advancelearningapp.datamodel.repo.CourseRepo;
import com.example.advancelearningapp.domain.CourseDTO;
import com.example.advancelearningapp.domain.inboud.CourseDTOIn;
import com.example.advancelearningapp.services.ICourseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements ICourseService {
    @Autowired
    CourseRepo courseRepo;
    @Override
    public CourseDTO createCourse(CourseDTOIn courseDTOIn) {
        ModelMapper mp = new ModelMapper();
        Course course = mp.map(courseDTOIn, Course.class);
        courseRepo.save(course);
        CourseDTO courseDTO = mp.map(course,CourseDTO.class);
        return courseDTO;
    }

    @Override
    public void updateCourse(String courseId, CourseDTOIn courseDTOIn) {
        Optional<Course> course = courseRepo.findById(courseId);
        if(course.isPresent()){
            ModelMapper mp = new ModelMapper();
            Course updatedCourse = course.get();
            mp.map(courseDTOIn,updatedCourse);
            courseRepo.save(updatedCourse);
        }
        //else mn na lgayen tou error q ata?
        else{
            throw new IllegalArgumentException("Invalid input");
        }
    }
    @Override
    public void deleteCourse(String courseId) {
        Optional<Course> course = courseRepo.findById(courseId);
        if(course.isEmpty()){
            throw new IllegalArgumentException("Course not found");
        }
        courseRepo.deleteById(courseId);
    }
    @Override
    public List<CourseDTO> getCourses() {
        return courseRepo.findAllCourses();
    }
}
