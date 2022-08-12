package com.example.advancelearningapp.datamodel.repo;

import com.example.advancelearningapp.datamodel.Course;
import com.example.advancelearningapp.domain.CourseDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CourseRepo extends PagingAndSortingRepository<Course, String> {
    @Query("select new com.example.advancelearningapp.domain.CourseDTO(course, courseId, author,description) from Course")
    List<CourseDTO> findAllCourses();
}
