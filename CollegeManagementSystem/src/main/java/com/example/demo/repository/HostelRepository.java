package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Hostel;
@Repository
public interface HostelRepository extends JpaRepository<Hostel, Long> {
}