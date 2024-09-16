package com.example.demo.service;

import com.example.demo.model.Alumni;
import java.util.List;

public interface AlumniService {
    Alumni create(Alumni alumni);
    Alumni getById(Long id);
    List<Alumni> getAll();
    Alumni update(Long id, Alumni alumni);
    void delete(Long id);
}
