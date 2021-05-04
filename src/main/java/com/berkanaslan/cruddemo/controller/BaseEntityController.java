package com.berkanaslan.cruddemo.controller;

import com.berkanaslan.cruddemo.model.BaseEntity;
import com.berkanaslan.cruddemo.model.Employee;
import com.berkanaslan.cruddemo.repository.BaseEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public abstract class BaseEntityController<T extends BaseEntity> {

    public abstract Class<T> getEntityClass();

    @Autowired
    BaseEntityRepository<T> baseEntityRepository;

    @GetMapping()
    public List<T> findAll() {
        return baseEntityRepository.findAll();
    }

    @GetMapping("{id}")
    public T findById(@PathVariable long id) {
        Optional<T> optional = baseEntityRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        throw new RuntimeException("No such " + getEntityClass().getSimpleName());
    }

    @PostMapping
    public T save(@RequestBody T t) {
        baseEntityRepository.save(t);
        return t;
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable long id) {
        baseEntityRepository.deleteById(id);
    }
}
