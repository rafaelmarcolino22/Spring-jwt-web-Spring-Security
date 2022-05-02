package com.curso.rafael.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.curso.rafael.domain.enums.TipoCliente;

public class Cliente {
	
	private Integer id;
	private String nome;
	private String email;
	private String cpfOuCnpj;
	private TipoCliente tipo;
	
	private List<Endereco> endereco = new ArrayList<>();
	
	private Set<String> telefones = new HashSet<>();
	
	
	public Cliente() {
		
	}


	public Cliente(Integer id, String nome, String email, String cpfOuCnpj, TipoCliente tipo) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpfOuCnpj = cpfOuCnpj;
		this.tipo = tipo;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}


	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}


	public TipoCliente getTipo() {
		return tipo;
	}


	public void setTipo(TipoCliente tipo) {
		this.tipo = tipo;
	}


	public List<Endereco> getEndereco() {
		return endereco;
	}


	public void setEndereco(List<Endereco> endereco) {
		this.endereco = endereco;
	}


	public Set<String> getTelefones() {
		return telefones;
	}


	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}
	
}
