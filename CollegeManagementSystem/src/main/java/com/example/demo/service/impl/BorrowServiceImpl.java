package com.example.demo.service.impl;

import com.example.demo.model.Borrow;
import com.example.demo.repository.BorrowRepository;
import com.example.demo.service.BorrowService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowServiceImpl implements BorrowService {

    @Autowired
    private BorrowRepository borrowRepository;

    @Override
    public Borrow createBorrow(Borrow borrow) {
        return borrowRepository.save(borrow);
    }

    @Override
    public Borrow getBorrowById(Long id) throws ResourceNotFoundException {
        return borrowRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Borrow not found with id: " + id));
    }

    @Override
    public List<Borrow> getAllBorrows() {
        return borrowRepository.findAll();
    }

    @Override
    public Borrow updateBorrow(Long id, Borrow borrow) throws ResourceNotFoundException {
        if (!borrowRepository.existsById(id)) {
            throw new ResourceNotFoundException("Borrow not found with id: " + id);
        }
        borrow.setId(id);
        return borrowRepository.save(borrow);
    }

    @Override
    public void deleteBorrow(Long id) throws ResourceNotFoundException {
        if (!borrowRepository.existsById(id)) {
            throw new ResourceNotFoundException("Borrow not found with id: " + id);
        }
        borrowRepository.deleteById(id);
    }
}
