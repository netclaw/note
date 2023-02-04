package com.notexor.notex.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Matiere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long matiereId;
    @Column(unique = true)
    private String nom;
    private int volumeHoraire;
    private int semestre;
    @OneToMany(mappedBy = "matiere", cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Professeur> professeurs = new ArrayList<>();

    @OneToMany(mappedBy = "matiere")
    @JsonIgnore
    private List<Note> notes = new ArrayList<>();

    public void addProfesseur(Professeur professeur) {
        professeurs.add(professeur);
        professeur.setMatiere(this);
    }

    public void removeProfesseur(Professeur professeur) {
        professeurs.remove(professeur);
        professeur.setMatiere(null);
    }

    public Matiere(String nom, int VolumeHoraire, int semestre) {
        setNom(nom);
        setVolumeHoraire(VolumeHoraire);
        setSemestre(semestre);
    }

}
