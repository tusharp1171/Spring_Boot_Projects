package com.example.demo.service;

import com.example.demo.model.Assignment;
import com.example.demo.exception.ResourceNotFoundException;

import java.util.List;

public interface AssignmentService {
    Assignment createAssignment(Assignment assignment);
    Assignment getAssignmentById(Long id) throws ResourceNotFoundException;
    List<Assignment> getAllAssignments();
    Assignment updateAssignment(Long id, Assignment assignment) throws ResourceNotFoundException;
    void deleteAssignment(Long id) throws ResourceNotFoundException;
}
