package com.example.advancelearningapp.domain.inboud;

public class CourseDTOIn {
    String course;
    String courseId;
    String author;
    String description;

    public CourseDTOIn() {
    }

    public CourseDTOIn(String course, String courseId, String author, String description) {
        this.course = course;
        this.courseId = courseId;
        this.author = author;
        this.description = description;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
