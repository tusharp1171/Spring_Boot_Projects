package com.example.demo.service;

import com.example.demo.model.Borrow;
import com.example.demo.exception.ResourceNotFoundException;

import java.util.List;

public interface BorrowService {
    Borrow createBorrow(Borrow borrow);
    Borrow getBorrowById(Long id) throws ResourceNotFoundException;
    List<Borrow> getAllBorrows();
    Borrow updateBorrow(Long id, Borrow borrow) throws ResourceNotFoundException;
    void deleteBorrow(Long id) throws ResourceNotFoundException;
}
