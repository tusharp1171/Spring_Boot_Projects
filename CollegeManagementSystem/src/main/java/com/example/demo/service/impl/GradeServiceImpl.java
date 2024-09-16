package com.example.demo.service.impl;

import com.example.demo.model.Grade;
import com.example.demo.repository.GradeRepository;
import com.example.demo.service.GradeService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {

    @Autowired
    private GradeRepository gradeRepository;

    @Override
    public Grade createGrade(Grade grade) {
        return gradeRepository.save(grade);
    }

    @Override
    public Grade getGradeById(Long id) throws ResourceNotFoundException {
        return gradeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Grade not found with id: " + id));
    }

    @Override
    public List<Grade> getAllGrades() {
        return gradeRepository.findAll();
    }

    @Override
    public Grade updateGrade(Long id, Grade grade) throws ResourceNotFoundException {
        if (!gradeRepository.existsById(id)) {
            throw new ResourceNotFoundException("Grade not found with id: " + id);
        }
        grade.setId(id);
        return gradeRepository.save(grade);
    }

    @Override
    public void deleteGrade(Long id) throws ResourceNotFoundException {
        if (!gradeRepository.existsById(id)) {
            throw new ResourceNotFoundException("Grade not found with id: " + id);
        }
        gradeRepository.deleteById(id);
    }
}
