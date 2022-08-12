package com.example.advancelearningapp.domain;

import com.example.advancelearningapp.domain.inboud.CourseDTOIn;

public class CourseDTO extends CourseDTOIn {
    String course;
    String courseId;
    String author;
    String description;

    public CourseDTO() {
    }

    public CourseDTO(String course, String courseId, String author, String description) {
        super(course, courseId, author, description);
    }

    /*@Override
    public String getCourse() {
        return course;
    }

    @Override
    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String getCourseId() {
        return courseId;
    }

    @Override
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }*/
}
