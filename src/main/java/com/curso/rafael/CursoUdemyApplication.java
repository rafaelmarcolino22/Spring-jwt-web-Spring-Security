package com.curso.rafael;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.curso.rafael.domain.Categoria;
import com.curso.rafael.domain.Cidade;
import com.curso.rafael.domain.Cliente;
import com.curso.rafael.domain.Endereco;
import com.curso.rafael.domain.Estado;
import com.curso.rafael.domain.Produto;
import com.curso.rafael.domain.enums.TipoCliente;
import com.curso.rafael.repositories.CategoriaRepository;
import com.curso.rafael.repositories.CidadeRepository;
import com.curso.rafael.repositories.ClienteRepository;
import com.curso.rafael.repositories.EnderecoRepository;
import com.curso.rafael.repositories.EstadoRepository;
import com.curso.rafael.repositories.ProdutoRepository;

@SpringBootApplication
public class CursoUdemyApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRespository;
	

	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursoUdemyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "informatica");
		Categoria cat2 = new Categoria(null, "escritorio");
		
		Produto p1 =  new Produto(null, "Computador", 2000.00);
		Produto p2 =  new Produto(null, "Impressora", 800.00);
		Produto p3 =  new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "Sao Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "Sao Paulo", est2);
		Cidade c3 = new Cidade(null, "Cmapinas", est2);
		
		est1.getCidade().addAll(Arrays.asList(c1));
		est2.getCidade().addAll(Arrays.asList(c2, c3));
		
		estadoRespository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		
		Cliente clie1 = new Cliente(null, "Maria silva", "maria@gmail.com", "367787845448", TipoCliente.PESSOALFISSICA);
		clie1.getTelefones().addAll(Arrays.asList("25698589", "369858585"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "apto 303", "Jardim", "389858969", clie1, c1);
		Endereco e2 = new Endereco(null, "Rua polo", "600", "apto 400", "flores", "389858969", clie1, c2);
		
		clie1.getEndereco().addAll(Arrays.asList(e1, e2));
		
		clienteRepository.saveAll(Arrays.asList(clie1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));

		
	}

}
