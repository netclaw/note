package com.notexor.notex.model;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@Entity
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long matricule;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "compteId", referencedColumnName = "compteId")
    private Compte compte;

    public void setCompte(Compte compte) {
        this.compte = compte;
        compte.setPersonne(this);
    }

}
