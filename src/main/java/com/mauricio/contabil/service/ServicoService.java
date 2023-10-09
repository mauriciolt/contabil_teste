package com.mauricio.contabil.service;

//endpoint para os serviços.

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mauricio.contabil.domain.Servico;
import com.mauricio.contabil.repository.ServicoRepository;
import com.mauricio.contabil.service.exceptions.ObjetoNaoEncontradoException;

@Service
public class ServicoService {
	
	@Autowired
	private ServicoRepository repo;
	
	public Servico find(Integer id) {
		Optional<Servico> obj = repo.findById(id);
		return obj.orElseThrow( () -> new ObjetoNaoEncontradoException( "Objeto não encontrado. ID: " + id + ", Tipo: " + Servico.class.getName()));
	}
	
}
