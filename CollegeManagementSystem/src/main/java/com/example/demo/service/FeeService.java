package com.example.demo.service;

import com.example.demo.model.Fee;
import java.util.List;

public interface FeeService {
    Fee create(Fee fee);
    Fee getById(Long id);
    List<Fee> getAll();
    Fee update(Long id, Fee fee);
    void delete(Long id);
}
