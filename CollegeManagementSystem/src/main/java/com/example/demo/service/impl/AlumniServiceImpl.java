package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Alumni;
import com.example.demo.repository.AlumniRepository;
import com.example.demo.service.AlumniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumniServiceImpl implements AlumniService {

    @Autowired
    private AlumniRepository alumniRepository;

    @Override
    public Alumni create(Alumni alumni) {
        return alumniRepository.save(alumni);
    }

    @Override
    public Alumni getById(Long id) throws ResourceNotFoundException {
        return alumniRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Alumni not found with ID: " + id));
    }

    @Override
    public List<Alumni> getAll() {
        return alumniRepository.findAll();
    }

    @Override
    public Alumni update(Long id, Alumni alumni) throws ResourceNotFoundException {
        Alumni existingAlumni = getById(id);
      //  existingAlumni.setName(alumni.getName()); // Update other fields
       existingAlumni.setName(alumni.getName());
        return alumniRepository.save(existingAlumni);
    }

    @Override
    public void delete(Long id) throws ResourceNotFoundException {
        Alumni existingAlumni = getById(id);
        alumniRepository.delete(existingAlumni);
    }
}
