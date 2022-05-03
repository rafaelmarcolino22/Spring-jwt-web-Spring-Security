package com.curso.rafael.domain;

import com.curso.rafael.domain.enums.EstadoPagamento;

public class PagamentoComCartao extends Pagamento {
	

	private Integer numerosDeParcelas;

	public PagamentoComCartao() {
		
	}

	public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer numerosDeParcelas ) {
		super(id, estado, pedido);
		this.numerosDeParcelas = numerosDeParcelas;
		
	}

	public Integer getNumerosDeParcelas() {
		return numerosDeParcelas;
	}

	public void setNumerosDeParcelas(Integer numerosDeParcelas) {
		this.numerosDeParcelas = numerosDeParcelas;
	}
	
	
	
	
	



	

	
	
}
