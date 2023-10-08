package com.mauricio.contabil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mauricio.contabil.domain.Cadastro;

@Repository
public interface CadastroRepository extends JpaRepository<Cadastro, Integer> {

}
