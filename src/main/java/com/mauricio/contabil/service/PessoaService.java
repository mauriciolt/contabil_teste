package com.mauricio.contabil.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.mauricio.contabil.domain.Pessoa;
import com.mauricio.contabil.domain.Pessoa;
import com.mauricio.contabil.repository.PessoaRepository;
import com.mauricio.contabil.service.exceptions.DataIntegrityException;
import com.mauricio.contabil.service.exceptions.ObjetoNaoEncontradoException;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository repo;
	
	public Pessoa find(Integer id) {
		Optional<Pessoa> obj = repo.findById(id);
		return obj.orElseThrow( () -> new ObjetoNaoEncontradoException( "Objeto não encontrado. ID: " + id + ", Tipo: " + Pessoa.class.getName()));
	}
	public Pessoa insert(Pessoa obj) {
		obj.setId(null);
		return repo.save(obj);

	}

	public Pessoa update(Pessoa obj) {
		find(obj.getId());
		return repo.save(obj);

	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Pessoa pode ser deletada!");
		}

	}
	public List<Pessoa> findAll() {
		
		return repo.findAll();
	}
	
}
