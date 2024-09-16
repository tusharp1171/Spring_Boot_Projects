package com.example.demo.controller;

import com.example.demo.model.Fee;
import com.example.demo.service.FeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fees")
public class FeeController {

    @Autowired
    private FeeService feeService;

    // Create a new fee
    @PostMapping
    public ResponseEntity<Fee> createFee(@RequestBody Fee fee) {
        Fee createdFee = feeService.create(fee);
        return new ResponseEntity<>(createdFee, HttpStatus.CREATED);
    }

    // Get fee by ID
    @GetMapping("/{id}")
    public ResponseEntity<Fee> getFeeById(@PathVariable Long id) {
        Fee fee = feeService.getById(id);
        return new ResponseEntity<>(fee, HttpStatus.OK);
    }

    // Get all fees
    @GetMapping
    public ResponseEntity<List<Fee>> getAllFees() {
        List<Fee> fees = feeService.getAll();
        return new ResponseEntity<>(fees, HttpStatus.OK);
    }

    // Update a fee
    @PutMapping("/{id}")
    public ResponseEntity<Fee> updateFee(@PathVariable Long id, @RequestBody Fee fee) {
        Fee updatedFee = feeService.update(id, fee);
        return new ResponseEntity<>(updatedFee, HttpStatus.OK);
    }

    // Delete a fee
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFee(@PathVariable Long id) {
        feeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
