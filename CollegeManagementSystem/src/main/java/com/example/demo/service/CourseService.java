package com.example.demo.service;
import com.example.demo.model.Course;
import com.example.demo.exception.ResourceNotFoundException;

import java.util.List;

public interface CourseService {
    Course createCourse(Course course);
    Course getCourseById(Long id) throws ResourceNotFoundException;
    List<Course> getAllCourses();
    Course updateCourse(Long id, Course course) throws ResourceNotFoundException;
    void deleteCourse(Long id) throws ResourceNotFoundException;
}

