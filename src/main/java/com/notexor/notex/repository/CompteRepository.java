package com.notexor.notex.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.notexor.notex.model.Compte;

public interface CompteRepository extends JpaRepository<Compte, Long> {

    public Optional<Compte> findByEmail(String email);

}
