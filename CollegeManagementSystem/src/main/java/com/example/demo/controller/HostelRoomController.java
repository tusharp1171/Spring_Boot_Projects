package com.example.demo.controller;

import com.example.demo.model.HostelRoom;
import com.example.demo.service.HostelRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hostel-rooms")
public class HostelRoomController {

    @Autowired
    private HostelRoomService hostelRoomService;

    // Create a new hostel room
    @PostMapping
    public ResponseEntity<HostelRoom> createHostelRoom(@RequestBody HostelRoom hostelRoom) {
        HostelRoom createdHostelRoom = hostelRoomService.create(hostelRoom);
        return new ResponseEntity<>(createdHostelRoom, HttpStatus.CREATED);
    }

    // Get hostel room by ID
    @GetMapping("/{id}")
    public ResponseEntity<HostelRoom> getHostelRoomById(@PathVariable Long id) {
        HostelRoom hostelRoom = hostelRoomService.getById(id);
        return new ResponseEntity<>(hostelRoom, HttpStatus.OK);
    }

    // Get all hostel rooms
    @GetMapping
    public ResponseEntity<List<HostelRoom>> getAllHostelRooms() {
        List<HostelRoom> hostelRooms = hostelRoomService.getAll();
        return new ResponseEntity<>(hostelRooms, HttpStatus.OK);
    }

    // Update a hostel room
    @PutMapping("/{id}")
    public ResponseEntity<HostelRoom> updateHostelRoom(@PathVariable Long id, @RequestBody HostelRoom hostelRoom) {
        HostelRoom updatedHostelRoom = hostelRoomService.update(id, hostelRoom);
        return new ResponseEntity<>(updatedHostelRoom, HttpStatus.OK);
    }

    // Delete a hostel room
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHostelRoom(@PathVariable Long id) {
        hostelRoomService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
