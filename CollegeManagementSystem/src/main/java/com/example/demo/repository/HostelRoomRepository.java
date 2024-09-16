package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.HostelRoom;
@Repository
public interface HostelRoomRepository extends JpaRepository<HostelRoom, Long> {
}