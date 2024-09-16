package com.example.demo.service.impl;

import com.example.demo.model.Assignment;
import com.example.demo.repository.AssignmentRepository;
import com.example.demo.service.AssignmentService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignmentServiceImpl implements AssignmentService {

    @Autowired
    private AssignmentRepository assignmentRepository;

    @Override
    public Assignment createAssignment(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    @Override
    public Assignment getAssignmentById(Long id) throws ResourceNotFoundException {
        return assignmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Assignment not found with id: " + id));
    }

    @Override
    public List<Assignment> getAllAssignments() {
        return assignmentRepository.findAll();
    }

    @Override
    public Assignment updateAssignment(Long id, Assignment assignment) throws ResourceNotFoundException {
        if (!assignmentRepository.existsById(id)) {
            throw new ResourceNotFoundException("Assignment not found with id: " + id);
        }
        assignment.setId(id);
        return assignmentRepository.save(assignment);
    }

    @Override
    public void deleteAssignment(Long id) throws ResourceNotFoundException {
        if (!assignmentRepository.existsById(id)) {
            throw new ResourceNotFoundException("Assignment not found with id: " + id);
        }
        assignmentRepository.deleteById(id);
    }
}
