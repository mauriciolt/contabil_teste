package com.mauricio.contabil.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Cliente extends Pessoa {

	private static final long serialVersionUID = 1L;

	private String tipo;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "cliente")
	List<Servico> servicos = new ArrayList<>();
	
	public Cliente () {
		
		
	}

	public Cliente(Integer id, String nome, String email, String tipo) {
		super(id, nome, email);
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}


	
	
	
	
}
