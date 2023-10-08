package com.mauricio.contabil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mauricio.contabil.domain.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

}
