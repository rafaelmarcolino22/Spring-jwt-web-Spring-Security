package com.curso.rafael.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.curso.rafael.domain.Categoria;
import com.curso.rafael.repositories.CategoriaRepository;
import com.curso.rafael.service.exception.DataIntegrityException;
import com.curso.rafael.service.exception.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	public CategoriaRepository respo;

	public Categoria find(Integer id) {

		Optional<Categoria> obj = respo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(

				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return respo.save(obj);
	}
	
	public Categoria update(Categoria obj) {
		find(obj.getId());
		return respo.save(obj); 
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			respo.deleteById(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Nao e possivel excluir uma categoria que possui produtos");
		}
	}
	
	public List<Categoria> findAll(){
		
		return respo.findAll();
	}
	
}
