package com.berkanaslan.cruddemo.dao;


import com.berkanaslan.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        Query query = entityManager.createQuery("from Employee");
        return query.getResultList();
    }

    @Override
    public Employee findById(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public void save(Employee employee) {
        Employee dbEmployee = entityManager.merge(employee);
        // Return the new generated employee id
        employee.setId(dbEmployee.getId());
    }

    @Override
    public void delete(int id) {
        Query query = entityManager.createQuery("DELETE FROM Employee WHERE id=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
