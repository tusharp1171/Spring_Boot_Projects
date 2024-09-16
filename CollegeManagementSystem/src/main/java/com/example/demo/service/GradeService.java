package com.example.demo.service;

import com.example.demo.model.Grade;
import com.example.demo.exception.ResourceNotFoundException;

import java.util.List;

public interface GradeService {
    Grade createGrade(Grade grade);
    Grade getGradeById(Long id) throws ResourceNotFoundException;
    List<Grade> getAllGrades();
    Grade updateGrade(Long id, Grade grade) throws ResourceNotFoundException;
    void deleteGrade(Long id) throws ResourceNotFoundException;
}
