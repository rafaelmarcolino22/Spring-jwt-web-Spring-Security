package com.curso.rafael.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curso.rafael.domain.Endereco;

@Repository
public interface EnderecoRepository  extends JpaRepository<Endereco, Integer> {

}
