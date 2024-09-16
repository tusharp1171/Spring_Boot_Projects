package com.example.demo.service;

import com.example.demo.model.Teacher;
import com.example.demo.exception.ResourceNotFoundException;

import java.util.List;

public interface TeacherService {
    Teacher createTeacher(Teacher teacher);
    Teacher getTeacherById(Long id) throws ResourceNotFoundException;
    List<Teacher> getAllTeachers();
    Teacher updateTeacher(Long id, Teacher teacher) throws ResourceNotFoundException;
    void deleteTeacher(Long id) throws ResourceNotFoundException;
}
