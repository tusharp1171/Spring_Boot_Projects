package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Library;
import com.example.demo.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libraries")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @PostMapping
    public ResponseEntity<Library> createLibrary(@RequestBody Library library) {
        Library newLibrary = libraryService.createLibrary(library);
        return ResponseEntity.ok(newLibrary);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Library> getLibraryById(@PathVariable Long id) throws ResourceNotFoundException {
        Library library = libraryService.getLibraryById(id);
        return ResponseEntity.ok(library);
    }

    @GetMapping
    public List<Library> getAllLibraries() {
        return libraryService.getAllLibraries();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Library> updateLibrary(@PathVariable Long id, @RequestBody Library library) throws ResourceNotFoundException {
        Library updatedLibrary = libraryService.updateLibrary(id, library);
        return ResponseEntity.ok(updatedLibrary);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLibrary(@PathVariable Long id) throws ResourceNotFoundException {
        libraryService.deleteLibrary(id);
        return ResponseEntity.noContent().build();
    }
}
