package com.berkanaslan.cruddemo.controller;

import com.berkanaslan.cruddemo.model.BaseEntity;
import com.berkanaslan.cruddemo.repository.BaseEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public abstract class BaseEntityController<T extends BaseEntity, I extends BaseEntity.Info> {

    @Autowired
    protected BaseEntityRepository<T> baseEntityRepository;

    public abstract Class<T> getEntityClass();

    public abstract Class<I> getEntityInfoClass();

    public abstract String getRequestPath();

    public BaseEntityRepository<T> getBaseEntityRepository() {
        return baseEntityRepository;
    }

    protected void setBaseEntityRepository(BaseEntityRepository<T> baseEntityRepository) {
        this.baseEntityRepository = baseEntityRepository;
    }

    /* ---------------------- GET ALL ---------------------- */
    @GetMapping
    public List<T> getAll() {
        return baseEntityRepository.findAll();
    }
    /* ---------------------- GET ALL ---------------------- */

    /* ---------------------- GET SINGLE ---------------------- */
    @GetMapping("/{id}")
    public T getById(@PathVariable(name = "id") long id) {
        Optional<T> optional = baseEntityRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        throw new RuntimeException("No such " + getEntityClass().getSimpleName());
    }

    @GetMapping("/{id}/i")
    public I getByIdInfo(@PathVariable(name = "id") long id) {
        Optional<I> optional = baseEntityRepository.findById(id, getEntityInfoClass());
        if (optional.isPresent()) {
            return optional.get();
        }
        throw new RuntimeException("No such " + getEntityClass().getSimpleName());
    }
    /* ---------------------- GET SINGLE ---------------------- */

    /* ---------------------- MODIFY ---------------------- */
    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable(name = "id") long id) throws IOException {
        baseEntityRepository.deleteById(id);
    }

    @PostMapping
    public long save(@RequestBody T t) {
        baseEntityRepository.save(t);
        return t.getId();
    }

    @PostMapping(path = "/all")
    public void saveAll(@RequestBody List<T> t) {
        baseEntityRepository.saveAll(t);
    }
    /* ---------------------- MODIFY ---------------------- */


}
