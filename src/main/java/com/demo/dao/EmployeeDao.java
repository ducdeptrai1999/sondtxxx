package com.demo.dao;

import com.demo.model.Employee;

import java.util.List;

public interface EmployeeDao {
    Employee insert(Employee employee);
    void update(Employee employee);
    void delete(int Id);
    List<Employee> findAll();
}
