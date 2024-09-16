package com.example.demo.service;

import com.example.demo.model.Payment;
import java.util.List;

public interface PaymentService {
    Payment create(Payment payment);
    Payment getById(Long id);
    List<Payment> getAll();
    Payment update(Long id, Payment payment);
    void delete(Long id);
}
