package com.example.advancelearningapp.datamodel.repo;

import com.example.advancelearningapp.datamodel.StudentCourseRelation;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StudentCourseRelationRepo extends PagingAndSortingRepository<StudentCourseRelation,String> {
}
