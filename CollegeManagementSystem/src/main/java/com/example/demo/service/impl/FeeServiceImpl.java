package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Fee;
import com.example.demo.repository.FeeRepository;
import com.example.demo.service.FeeService;

@Service
public class FeeServiceImpl implements FeeService {

    @Autowired
    private FeeRepository feeRepository;

    @Override
    public Fee create(Fee fee) {
        return feeRepository.save(fee);
    }

    @Override
    public Fee getById(Long id) throws ResourceNotFoundException {
        return feeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Fee not found with ID: " + id));
    }

    @Override
    public List<Fee> getAll() {
        return feeRepository.findAll();
    }

    @Override
    public Fee update(Long id, Fee fee) throws ResourceNotFoundException {
        Fee existingFee = getById(id);
        existingFee.setAmount(fee.getAmount()); // Update other fields
        return feeRepository.save(existingFee);
    }

    @Override
    public void delete(Long id) throws ResourceNotFoundException {
        Fee existingFee = getById(id);
        feeRepository.delete(existingFee);
    }
}
