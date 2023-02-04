package com.notexor.notex.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.notexor.notex.model.Personne;

public interface PersonneRepository extends JpaRepository<Personne, Long> {

    public Optional<Personne> findByNomAndPrenom(String nom, String prenom);

}
