package com.example.demo.service.impl;

import com.example.demo.model.Library;
import com.example.demo.repository.LibraryRepository;
import com.example.demo.service.LibraryService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    private LibraryRepository libraryRepository;

    @Override
    public Library createLibrary(Library library) {
        return libraryRepository.save(library);
    }

    @Override
    public Library getLibraryById(Long id) throws ResourceNotFoundException {
        return libraryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Library not found with id: " + id));
    }

    @Override
    public List<Library> getAllLibraries() {
        return libraryRepository.findAll();
    }

    @Override
    public Library updateLibrary(Long id, Library library) throws ResourceNotFoundException {
        if (!libraryRepository.existsById(id)) {
            throw new ResourceNotFoundException("Library not found with id: " + id);
        }
        library.setId(id);
        return libraryRepository.save(library);
    }

    @Override
    public void deleteLibrary(Long id) throws ResourceNotFoundException {
        if (!libraryRepository.existsById(id)) {
            throw new ResourceNotFoundException("Library not found with id: " + id);
        }
        libraryRepository.deleteById(id);
    }
}
