package com.example.demo.service;


import com.example.demo.model.Hostel;
import java.util.List;

public interface HostelService {
    Hostel create(Hostel hostel);
    Hostel getById(Long id);
    List<Hostel> getAll();
    Hostel update(Long id, Hostel hostel);
    void delete(Long id);
}
