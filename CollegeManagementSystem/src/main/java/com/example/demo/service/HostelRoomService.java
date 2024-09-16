package com.example.demo.service;

import com.example.demo.model.HostelRoom;
import java.util.List;

public interface HostelRoomService {
    HostelRoom create(HostelRoom hostelRoom);
    HostelRoom getById(Long id);
    List<HostelRoom> getAll();
    HostelRoom update(Long id, HostelRoom hostelRoom);
    void delete(Long id);
}