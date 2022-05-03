package com.curso.rafael.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curso.rafael.domain.Pagamento;

@Repository
public interface PagamentoRepository  extends JpaRepository<Pagamento, Integer> {

}
