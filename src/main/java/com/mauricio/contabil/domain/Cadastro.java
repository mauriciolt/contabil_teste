package com.mauricio.contabil.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



// Cadastro = Pet
// id = id
// nome = nome
// idade = numero
// especie = tipocad - cpf ou cnpj
// raça = classecad - fisica, mei ou simples nacional




@Entity
public class Cadastro implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Integer id;
	private String nome;
	private Integer numero;
	
	@ManyToOne
	@JoinColumn (name = "id_tipocad")
	private TipoCad tipocad; // cpf ou cnpj
	
	@ManyToOne
	@JoinColumn (name = "id_classecad")
	private ClasseCad classecad; //fisica, mei ou simples nacional
	
	public Cadastro () { 
		
		
	}

	public Cadastro(Integer id, String nome, Integer numero, TipoCad tipocad, ClasseCad classecad) {
		super();
		this.id = id;
		this.nome = nome;
		this.numero = numero;
		this.tipocad = tipocad;
		this.classecad = classecad;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cadastro other = (Cadastro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public TipoCad getTipocad() {
		return tipocad;
	}

	public void setTipocad(TipoCad tipocad) {
		this.tipocad = tipocad;
	}

	public ClasseCad getClassecad() {
		return classecad;
	}

	public void setClassecad(ClasseCad classecad) {
		this.classecad = classecad;
	}
	
	
	
}
