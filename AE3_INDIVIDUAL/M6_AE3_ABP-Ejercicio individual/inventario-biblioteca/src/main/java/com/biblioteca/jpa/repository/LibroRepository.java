package com.biblioteca.jpa.repository;

import com.biblioteca.jpa.entity.LibroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends JpaRepository<LibroEntity, Long> { }