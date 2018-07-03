package com.codegym.basic.service;

import com.codegym.basic.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {

    Iterable<Employee> findAll();

    Employee findById(Long id);

    void save (Employee employee);

    void delete(Long id);

    Page<Employee> findAllByNameContaining(String name, Pageable pageable);
}
