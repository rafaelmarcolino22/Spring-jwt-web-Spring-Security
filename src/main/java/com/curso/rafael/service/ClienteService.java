package com.curso.rafael.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.rafael.domain.Cliente;
import com.curso.rafael.repositories.ClienteRepository;
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
}
