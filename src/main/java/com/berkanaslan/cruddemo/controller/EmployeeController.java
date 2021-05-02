package com.berkanaslan.cruddemo.controller;

import com.berkanaslan.cruddemo.model.BaseEntity;
import com.berkanaslan.cruddemo.model.Employee;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(EmployeeController.PATH)
public class EmployeeController extends BaseEntityController<Employee, BaseEntity.Info> {
    static final String PATH = "employee";

    @Override
    public Class<Employee> getEntityClass() {
        return Employee.class;
    }

    @Override
    public Class<BaseEntity.Info> getEntityInfoClass() {
        return Employee.Info.class;
    }

    @Override
    public String getRequestPath() {
        return PATH;
    }
}
