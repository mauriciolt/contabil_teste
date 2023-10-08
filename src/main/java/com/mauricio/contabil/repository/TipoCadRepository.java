package com.mauricio.contabil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mauricio.contabil.domain.TipoCad;

@Repository
public interface TipoCadRepository extends JpaRepository<TipoCad, Integer> {

}
