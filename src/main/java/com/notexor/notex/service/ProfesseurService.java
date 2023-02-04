package com.notexor.notex.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notexor.notex.model.Grade;
import com.notexor.notex.model.Matiere;
import com.notexor.notex.model.Personne;
import com.notexor.notex.model.Professeur;
import com.notexor.notex.repository.MatiereRepository;
import com.notexor.notex.repository.PersonneRepository;
import com.notexor.notex.repository.ProfesseurRepository;

@Service
public class ProfesseurService {
    @Autowired
    ProfesseurRepository pr;

    @Autowired
    PersonneRepository pesr;

    @Autowired
    MatiereRepository mr;

    public boolean ajouterunProfesseur(String nom, String prenom, String matiereNom, Grade grade) {
        Optional<Matiere> omatiere = mr.findByNom(matiereNom);
        if (omatiere.isPresent()) {
            Matiere matiere = omatiere.get();
            Professeur professeur = new Professeur(nom, prenom, matiere, grade);
            matiere.addProfesseur(professeur);
            mr.save(matiere);
            return true;
        }
        return false;

    }

    public boolean isProfesseurNonEnregistre(String nom, String prenom) {
        Optional<Personne> op = pesr.findByNomAndPrenom(nom, prenom);
        if (op.isPresent()) {
            if (op.get().getClass() == Professeur.class) {
                return false;
            }
        }
        return true;
    }

    public List<Professeur> afficherTousLesProfesseurs() {
        return pr.findAll();
    }

}
