package com.example.demo.service;

import java.util.List;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Student;

public interface StudentService {
    Student createStudent(Student student);
    Student getStudentById(Long id) throws ResourceNotFoundException;
    List<Student> getAllStudents();
    Student updateStudent(Long id, Student student) throws ResourceNotFoundException;
    void deleteStudent(Long id) throws ResourceNotFoundException;
}