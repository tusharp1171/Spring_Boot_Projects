package com.example.demo.controller;

import com.example.demo.model.Hostel;
import com.example.demo.service.HostelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hostels")
public class HostelController {

    @Autowired
    private HostelService hostelService;

    // Create a new hostel
    @PostMapping
    public ResponseEntity<Hostel> createHostel(@RequestBody Hostel hostel) {
        Hostel createdHostel = hostelService.create(hostel);
        return new ResponseEntity<>(createdHostel, HttpStatus.CREATED);
    }

    // Get hostel by ID
    @GetMapping("/{id}")
    public ResponseEntity<Hostel> getHostelById(@PathVariable Long id) {
        Hostel hostel = hostelService.getById(id);
        return new ResponseEntity<>(hostel, HttpStatus.OK);
    }

    // Get all hostels
    @GetMapping
    public ResponseEntity<List<Hostel>> getAllHostels() {
        List<Hostel> hostels = hostelService.getAll();
        return new ResponseEntity<>(hostels, HttpStatus.OK);
    }

    // Update a hostel
    @PutMapping("/{id}")
    public ResponseEntity<Hostel> updateHostel(@PathVariable Long id, @RequestBody Hostel hostel) {
        Hostel updatedHostel = hostelService.update(id, hostel);
        return new ResponseEntity<>(updatedHostel, HttpStatus.OK);
    }

    // Delete a hostel
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHostel(@PathVariable Long id) {
        hostelService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
