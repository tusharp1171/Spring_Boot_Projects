package com.example.demo.service;

import java.util.List;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Library;

public interface LibraryService {
    Library createLibrary(Library library);
    Library getLibraryById(Long id) throws ResourceNotFoundException;
    List<Library> getAllLibraries();
    Library updateLibrary(Long id, Library library) throws ResourceNotFoundException;
    void deleteLibrary(Long id) throws ResourceNotFoundException;
}