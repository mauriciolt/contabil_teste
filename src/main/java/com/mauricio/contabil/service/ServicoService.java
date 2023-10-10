package com.mauricio.contabil.service;

//endpoint para os serviços.

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.mauricio.contabil.domain.Servico;
import com.mauricio.contabil.domain.Servico;
import com.mauricio.contabil.repository.ServicoRepository;
import com.mauricio.contabil.service.exceptions.DataIntegrityException;
import com.mauricio.contabil.service.exceptions.ObjetoNaoEncontradoException;

@Service
public class ServicoService {
	
	@Autowired
	private ServicoRepository repo;
	
	public Servico find(Integer id) {
		Optional<Servico> obj = repo.findById(id);
		return obj.orElseThrow( () -> new ObjetoNaoEncontradoException( "Objeto não encontrado. ID: " + id + ", Tipo: " + Servico.class.getName()));
	}
	
	public Servico insert(Servico obj) {
		obj.setId(null);
		return repo.save(obj);

	}

	public Servico update(Servico obj) {
		find(obj.getId());
		return repo.save(obj);

	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Servico possui produtos, não é possível deletar!");
		}

	}
	
}
