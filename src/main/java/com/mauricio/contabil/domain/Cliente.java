package com.mauricio.contabil.domain;

import javax.persistence.Entity;

@Entity
public class Cliente extends Pessoa {

	private static final long serialVersionUID = 1L;

	private String tipo;
	
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


	
	
	
	
}
