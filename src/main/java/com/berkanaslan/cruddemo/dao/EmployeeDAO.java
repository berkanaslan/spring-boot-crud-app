package com.berkanaslan.cruddemo.dao;


import com.berkanaslan.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> findAll();

    public Employee findById(int id);

    public void save(Employee employee);

    public void delete(int id);
}