package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Hostel;
import com.example.demo.repository.HostelRepository;
import com.example.demo.service.HostelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HostelServiceImpl implements HostelService {

    @Autowired
    private HostelRepository hostelRepository;

    @Override
    public Hostel create(Hostel hostel) {
        return hostelRepository.save(hostel);
    }

    @Override
    public Hostel getById(Long id) throws ResourceNotFoundException {
        return hostelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hostel not found with ID: " + id));
    }

    @Override
    public List<Hostel> getAll() {
        return hostelRepository.findAll();
    }

    @Override
    public Hostel update(Long id, Hostel hostel) throws ResourceNotFoundException {
        Hostel existingHostel = getById(id);
        existingHostel.setName(hostel.getName()); // Update other fields
        return hostelRepository.save(existingHostel);
    }

    @Override
    public void delete(Long id) throws ResourceNotFoundException {
        Hostel existingHostel = getById(id);
        hostelRepository.delete(existingHostel);
    }
}
