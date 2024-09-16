package com.example.demo.service;



import com.example.demo.model.Department;
import com.example.demo.exception.ResourceNotFoundException;

import java.util.List;

public interface DepartmentService {
    Department createDepartment(Department department);
    Department getDepartmentById(Long id) throws ResourceNotFoundException;
    List<Department> getAllDepartments();
    Department updateDepartment(Long id, Department department) throws ResourceNotFoundException;
    void deleteDepartment(Long id) throws ResourceNotFoundException;
}
