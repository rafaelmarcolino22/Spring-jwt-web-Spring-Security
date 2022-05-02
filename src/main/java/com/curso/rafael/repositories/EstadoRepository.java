package com.curso.rafael.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curso.rafael.domain.Estado;

@Repository
public interface EstadoRepository  extends JpaRepository<Estado, Integer> {

}
