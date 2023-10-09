package com.mauricio.contabil.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Funcionario extends Pessoa {

	private static final long serialVersionUID = 1L;

	private String funcao;
	
	@OneToMany(mappedBy = "funcionario")
	List<Servico> servicos = new ArrayList<>();
	
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

	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}
	
	
	
	
}
