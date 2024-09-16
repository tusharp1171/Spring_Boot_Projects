package com.example.demo.service.impl;

import com.example.demo.model.Classroom;
import com.example.demo.repository.ClassroomRepository;
import com.example.demo.service.ClassroomService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomServiceImpl implements ClassroomService {

    @Autowired
    private ClassroomRepository classroomRepository;

    @Override
    public Classroom createClassroom(Classroom classroom) {
        return classroomRepository.save(classroom);
    }

    @Override
    public Classroom getClassroomById(Long id) throws ResourceNotFoundException {
        return classroomRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Classroom not found with id: " + id));
    }

    @Override
    public List<Classroom> getAllClassrooms() {
        return classroomRepository.findAll();
    }

    @Override
    public Classroom updateClassroom(Long id, Classroom classroom) throws ResourceNotFoundException {
        if (!classroomRepository.existsById(id)) {
            throw new ResourceNotFoundException("Classroom not found with id: " + id);
        }
        classroom.setId(id);
        return classroomRepository.save(classroom);
    }

    @Override
    public void deleteClassroom(Long id) throws ResourceNotFoundException {
        if (!classroomRepository.existsById(id)) {
            throw new ResourceNotFoundException("Classroom not found with id: " + id);
        }
        classroomRepository.deleteById(id);
    }
}
