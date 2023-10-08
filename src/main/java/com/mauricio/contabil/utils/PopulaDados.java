package com.mauricio.contabil.utils;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mauricio.contabil.domain.Cadastro;
import com.mauricio.contabil.domain.Categoria;
import com.mauricio.contabil.domain.ClasseCad;
import com.mauricio.contabil.domain.Produto;
import com.mauricio.contabil.domain.TipoCad;
import com.mauricio.contabil.repository.CadastroRepository;
import com.mauricio.contabil.repository.CategoriaRepository;
import com.mauricio.contabil.repository.ClasseCadRepository;
import com.mauricio.contabil.repository.ProdutoRepository;
import com.mauricio.contabil.repository.TipoCadRepository;

@Component
public class PopulaDados {

	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	TipoCadRepository tipocadRepository;
	
	@Autowired
	ClasseCadRepository classecadRepository;
	
	@Autowired
	CadastroRepository cadastroRepository;
	
	
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
		
		TipoCad tipocad1 = new TipoCad(null, "CPF");
		TipoCad tipocad2 = new TipoCad(null, "CNPJ");
		
		ClasseCad classecad1 = new ClasseCad(null, "Física");
		ClasseCad classecad2 = new ClasseCad(null, "MEI");
		ClasseCad classecad3 = new ClasseCad(null, "Simples Nacional");
		
		Cadastro cad1 = new Cadastro(null, "Pessoa Teste", 1234567890, tipocad1, classecad1);
		Cadastro cad2 = new Cadastro(null, "MEI Teste", 000111222333, tipocad2, classecad2);
		Cadastro cad3 = new Cadastro(null, "Empresa Teste", 000222333444, tipocad2, classecad3);
		
		tipocadRepository.saveAll(Arrays.asList(tipocad1, tipocad2));
		classecadRepository.saveAll(Arrays.asList(classecad1, classecad2, classecad3));
		
		cadastroRepository.saveAll(Arrays.asList(cad1, cad2, cad3));
		
}
}
