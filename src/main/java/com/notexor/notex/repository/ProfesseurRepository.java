package com.notexor.notex.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.notexor.notex.model.Professeur;

public interface ProfesseurRepository extends JpaRepository<Professeur, Long> {

}
