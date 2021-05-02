package com.berkanaslan.cruddemo.repository;

import com.berkanaslan.cruddemo.model.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface BaseEntityRepository<T extends BaseEntity> extends JpaRepository<T, Long> {
    <V> Optional<V> getById(long id, Class<V> cls);

    <V> Optional<V> findById(long id, Class<V> type);

    <V> List<V> findAllBy(Class<V> type, Sort sort);

    <V> Page<V> findAllPagedBy(Pageable pageable, Class<V> type);
}
