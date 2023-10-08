package com.mauricio.contabil.domain;

import javax.persistence.Entity;

@Entity
public class Funcionario extends Pessoa {

	private static final long serialVersionUID = 1L;

	private String funcao;
	
	public Funcionario () {
		
		
	}

	public Funcionario(Integer id, String nome, String email, String funcao) {
		super(id, nome, email);
		this.funcao = funcao;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	
	
	
	
}
