package com.curso.rafael.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.curso.rafael.domain.Cliente;
import com.curso.rafael.dto.ClienteDTO;
import com.curso.rafael.repositories.ClienteRepository;
import com.curso.rafael.service.exception.DataIntegrityException;
import com.curso.rafael.service.exception.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	public ClienteRepository respo;

	public Cliente find(Integer id) {

		Optional<Cliente> obj = respo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(

				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}

	public Cliente update(Cliente obj) {
		Cliente newObj = find(obj.getId());
		updateData(newObj, obj);
		return respo.save(obj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			respo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Nao e possivel excluir uma categoria que possui produtos");
		}
	}

	public List<Cliente> findAll() {

		return respo.findAll();
	}

	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {

		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return respo.findAll(pageRequest);
	}

	public Cliente fromDTO(ClienteDTO objDto) {

		return new Cliente(objDto.getId(), objDto.getNome(), objDto.getEmail(), null, null);
	}
	
	private void updateData(Cliente newObj, Cliente obj) {
		newObj.setNome(obj.getNome());
	}
}
