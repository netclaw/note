package com.notexor.notex.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.notexor.notex.model.Matiere;

public interface MatiereRepository extends JpaRepository<Matiere, Long> {

    public Optional<Matiere> findByNom(String nomMatiere);

}
