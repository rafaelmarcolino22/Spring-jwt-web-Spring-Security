package com.curso.rafael.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.curso.rafael.domain.Categoria;
import com.curso.rafael.domain.Produto;
import com.curso.rafael.repositories.CategoriaRepository;
import com.curso.rafael.repositories.ProdutoRepository;
import com.curso.rafael.service.exception.ObjectNotFoundException;

@Service
public class ProdutoService {

	@Autowired
	public ProdutoRepository repo;
	
	@Autowired
	public CategoriaRepository categoriaRespotiry; 

	public Produto find(Integer id) {

		Optional<Produto> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(

				"Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));
	}

	public Page<Produto> search(String nome, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction) {

		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		List<Categoria> categorias = categoriaRespotiry.findAllById(ids);
		return repo.findDistinctByNomeContainingAndCategoriasIn(nome, categorias, pageRequest);
	}
}
