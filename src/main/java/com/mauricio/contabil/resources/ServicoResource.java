package com.mauricio.contabil.resources;

// fachada para os serviços (REST controller)


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mauricio.contabil.domain.Servico;
import com.mauricio.contabil.service.ServicoService;

@RestController
@RequestMapping(value = "/servicos")
public class ServicoResource {
	
	@Autowired
	ServicoService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		Servico obj = service.find(id);		
		
		return ResponseEntity.ok().body(obj);
		
		
	
	}
	
}
