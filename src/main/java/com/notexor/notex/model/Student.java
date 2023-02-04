package com.notexor.notex.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;

import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@PrimaryKeyJoinColumn(name = "studentId")
public class Student extends Personne {

    private int niveau;
    private boolean anneReserve = false;

    public Student(String nom, String prenom, LocalDate dateNaissance, int niveau) {
        setNom(nom);
        setPrenom(prenom);
        setDateNaissance(dateNaissance);
        setNiveau(niveau);
    }
}
