package com.curso.rafael.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.rafael.domain.Categoria;
import com.curso.rafael.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	public CategoriaRepository respo;
	
	public Categoria find(Integer id) {
		
		Optional<Categoria> obj = respo.findById(id);
		return obj.orElse(null);
	}
}
