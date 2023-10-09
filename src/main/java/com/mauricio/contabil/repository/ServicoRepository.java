package com.mauricio.contabil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mauricio.contabil.domain.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Integer> {

}
