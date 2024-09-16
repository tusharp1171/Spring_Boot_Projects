package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Payment;
import com.example.demo.repository.PaymentRepository;
import com.example.demo.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment create(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Payment getById(Long id) throws ResourceNotFoundException {
        return paymentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Payment not found with ID: " + id));
    }

    @Override
    public List<Payment> getAll() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment update(Long id, Payment payment) throws ResourceNotFoundException {
        Payment existingPayment = getById(id);
        existingPayment.setAmount(payment.getAmount()); // Update other fields
        return paymentRepository.save(existingPayment);
    }

    @Override
    public void delete(Long id) throws ResourceNotFoundException {
        Payment existingPayment = getById(id);
        paymentRepository.delete(existingPayment);
    }
}
