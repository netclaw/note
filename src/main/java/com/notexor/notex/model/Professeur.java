package com.notexor.notex.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@PrimaryKeyJoinColumn(name = "professeurId")
public class Professeur extends Personne {

    @ManyToOne
    @JoinColumn(name = "matiereId", referencedColumnName = "matiereId")
    private Matiere matiere;

    @Enumerated(EnumType.STRING)
    private Grade grade;

    public Professeur(String nom, String prenom, Matiere matiere, Grade grade) {
        setNom(nom);
        setPrenom(prenom);
        setGrade(grade);
        setMatiere(matiere);
    }

}
