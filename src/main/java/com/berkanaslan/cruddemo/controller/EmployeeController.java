package com.berkanaslan.cruddemo.controller;

import com.berkanaslan.cruddemo.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(EmployeeController.PATH)
public class EmployeeController extends BaseEntityController<Employee> {
    static final String PATH = "employees";

    @Override
    public Class<Employee> getEntityClass() {
        return Employee.class;
    }
}
