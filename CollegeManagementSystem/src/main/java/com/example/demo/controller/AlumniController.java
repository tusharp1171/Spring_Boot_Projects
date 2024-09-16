package com.example.demo.controller;

import com.example.demo.model.Alumni;
import com.example.demo.service.AlumniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alumni")
public class AlumniController {

    @Autowired
    private AlumniService alumniService;

    // Create new Alumni
    @PostMapping
    public ResponseEntity<Alumni> createAlumni(@RequestBody Alumni alumni) {
        Alumni createdAlumni = alumniService.create(alumni);
        return new ResponseEntity<>(createdAlumni, HttpStatus.CREATED);
    }

    // Get Alumni by ID
    @GetMapping("/{id}")
    public ResponseEntity<Alumni> getAlumniById(@PathVariable Long id) {
        Alumni alumni = alumniService.getById(id);
        return new ResponseEntity<>(alumni, HttpStatus.OK);
    }

    // Get all Alumni
    @GetMapping
    public ResponseEntity<List<Alumni>> getAllAlumni() {
        List<Alumni> alumniList = alumniService.getAll();
        return new ResponseEntity<>(alumniList, HttpStatus.OK);
    }

    // Update Alumni
    @PutMapping("/{id}")
    public ResponseEntity<Alumni> updateAlumni(@PathVariable Long id, @RequestBody Alumni alumni) {
        Alumni updatedAlumni = alumniService.update(id, alumni);
        return new ResponseEntity<>(updatedAlumni, HttpStatus.OK);
    }

    // Delete Alumni
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlumni(@PathVariable Long id) {
        alumniService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
