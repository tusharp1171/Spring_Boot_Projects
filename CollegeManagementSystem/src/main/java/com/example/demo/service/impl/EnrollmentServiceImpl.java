package com.example.demo.service.impl;

import com.example.demo.model.Enrollment;
import com.example.demo.repository.EnrollmentRepository;
import com.example.demo.service.EnrollmentService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Override
    public Enrollment createEnrollment(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    @Override
    public Enrollment getEnrollmentById(Long id) throws ResourceNotFoundException {
        return enrollmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Enrollment not found with id: " + id));
    }

    @Override
    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }

    @Override
    public Enrollment updateEnrollment(Long id, Enrollment enrollment) throws ResourceNotFoundException {
        if (!enrollmentRepository.existsById(id)) {
            throw new ResourceNotFoundException("Enrollment not found with id: " + id);
        }
        enrollment.setId(id);
        return enrollmentRepository.save(enrollment);
    }

    @Override
    public void deleteEnrollment(Long id) throws ResourceNotFoundException {
        if (!enrollmentRepository.existsById(id)) {
            throw new ResourceNotFoundException("Enrollment not found with id: " + id);
        }
        enrollmentRepository.deleteById(id);
    }
}
