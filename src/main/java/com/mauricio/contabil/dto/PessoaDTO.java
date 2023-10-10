package com.mauricio.contabil.dto;

import java.io.Serializable;

import com.mauricio.contabil.domain.Pessoa;

public class PessoaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String email;

	public PessoaDTO() {
		
	}

	public PessoaDTO(Pessoa obj) {
		
		this.nome = obj.getNome();
		this.email = obj.getEmail();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
