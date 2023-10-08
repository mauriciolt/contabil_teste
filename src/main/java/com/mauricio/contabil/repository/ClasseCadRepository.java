package com.mauricio.contabil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mauricio.contabil.domain.ClasseCad;

@Repository
public interface ClasseCadRepository extends JpaRepository<ClasseCad, Integer> {

}
