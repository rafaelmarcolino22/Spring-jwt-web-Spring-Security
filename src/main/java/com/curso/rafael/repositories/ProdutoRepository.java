package com.curso.rafael.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curso.rafael.domain.Produto;

@Repository
public interface ProdutoRepository  extends JpaRepository<Produto, Integer> {

}
