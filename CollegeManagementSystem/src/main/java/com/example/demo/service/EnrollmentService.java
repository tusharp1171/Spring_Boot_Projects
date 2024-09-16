package com.example.demo.service;

import com.example.demo.model.Enrollment;
import com.example.demo.exception.ResourceNotFoundException;

import java.util.List;

public interface EnrollmentService {
    Enrollment createEnrollment(Enrollment enrollment);
    Enrollment getEnrollmentById(Long id) throws ResourceNotFoundException;
    List<Enrollment> getAllEnrollments();
    Enrollment updateEnrollment(Long id, Enrollment enrollment) throws ResourceNotFoundException;
    void deleteEnrollment(Long id) throws ResourceNotFoundException;
}
