package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.HostelRoom;
import com.example.demo.repository.HostelRoomRepository;
import com.example.demo.service.HostelRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HostelRoomServiceImpl implements HostelRoomService {

    @Autowired
    private HostelRoomRepository hostelRoomRepository;

    @Override
    public HostelRoom create(HostelRoom hostelRoom) {
        return hostelRoomRepository.save(hostelRoom);
    }

    @Override
    public HostelRoom getById(Long id) throws ResourceNotFoundException {
        return hostelRoomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("HostelRoom not found with ID: " + id));
    }

    @Override
    public List<HostelRoom> getAll() {
        return hostelRoomRepository.findAll();
    }

    @Override
    public HostelRoom update(Long id, HostelRoom hostelRoom) throws ResourceNotFoundException {
        HostelRoom existingHostelRoom = getById(id);
        existingHostelRoom.setRoomNumber(hostelRoom.getRoomNumber()); // Update other fields
        return hostelRoomRepository.save(existingHostelRoom);
    }

    @Override
    public void delete(Long id) throws ResourceNotFoundException {
        HostelRoom existingHostelRoom = getById(id);
        hostelRoomRepository.delete(existingHostelRoom);
    }
}
