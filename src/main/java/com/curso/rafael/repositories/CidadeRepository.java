package com.curso.rafael.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curso.rafael.domain.Cidade;

@Repository
public interface CidadeRepository  extends JpaRepository<Cidade, Integer> {

}
