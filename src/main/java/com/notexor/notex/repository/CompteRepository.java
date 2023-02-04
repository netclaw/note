package com.notexor.notex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.notexor.notex.model.Compte;

public interface CompteRepository extends JpaRepository<Compte, Long> {

}
