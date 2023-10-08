package com.mauricio.contabil.utils;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mauricio.contabil.domain.Categoria;
import com.mauricio.contabil.domain.Produto;
import com.mauricio.contabil.repository.CategoriaRepository;
import com.mauricio.contabil.repository.ProdutoRepository;

@Component
public class PopulaDados {

	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@PostConstruct //somente utilizar em bd virtual
public void cadastrar()  {
		
		Categoria cat1 = new Categoria(null, "Serviço");
		Categoria cat2 = new Categoria(null, "Orçamento");
	
		
		
		Produto p1 = new Produto(null, "Solicitar regularização de CPF", 100.0);
		Produto p2 = new Produto(null, "Solicitar regularização do CNPJ", 200.0);
		Produto p3 = new Produto(null, "solicitar abertura de MEI", 300.0);
		Produto p4 = new Produto(null, "solicitar orçamento", 0.0);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p4));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		p4.getCategorias().addAll(Arrays.asList(cat2));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3,p4));
}
}
