package com.mauricio.contabil.domain;

import java.sql.Date;

import javax.persistence.Entity;

import com.mauricio.contabil.domain.enums.SituacaoPagamento;

@Entity
public class PagPix extends Pagamento {
	
	private static final long serialVersionUID = 1L;
	
	
	private Date dataPagamento;
	private Double desconto;
	
	public PagPix() {
		
	}

	public PagPix(Integer id, Double valor, SituacaoPagamento situacao, Servico servico, Date dataPagamento, Double desconto) {
		super(id, valor, situacao, servico);
		this.dataPagamento = dataPagamento;
		this.desconto = desconto;
		// TODO Auto-generated constructor stub
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}
	
	
	
	
	
	
	

}
