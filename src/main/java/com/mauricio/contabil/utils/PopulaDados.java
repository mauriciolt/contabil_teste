package com.mauricio.contabil.utils;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mauricio.contabil.domain.Categoria;
import com.mauricio.contabil.repository.CategoriaRepository;

@Component
public class PopulaDados {

	@Autowired
	CategoriaRepository categoriaRepository;
	
	@PostConstruct //somente utilizar em bd virtual
public void cadastrar()  {
		
		Categoria cat1 = new Categoria(null, "Serviço");
		Categoria cat2 = new Categoria(null, "Orçamento");
	
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
}
}
