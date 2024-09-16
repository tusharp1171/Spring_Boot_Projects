package com.example.demo.service;

import java.util.List;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Classroom;

public interface ClassroomService {
    Classroom createClassroom(Classroom classroom);
    Classroom getClassroomById(Long id) throws ResourceNotFoundException;
    List<Classroom> getAllClassrooms();
    Classroom updateClassroom(Long id, Classroom classroom) throws ResourceNotFoundException;
    void deleteClassroom(Long id) throws ResourceNotFoundException;
}
