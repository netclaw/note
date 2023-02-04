package com.notexor.notex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notexor.notex.model.Professeur;
import com.notexor.notex.service.ProfesseurService;

@RestController
@RequestMapping("professeurs")
public class ProfesseurController {

    @Autowired
    ProfesseurService ps;

    @PostMapping("add")
    public String ajouterMatiere(@RequestBody Professeur professeur) {
        if (ps.isProfesseurNonEnregistre(professeur.getNom(), professeur.getPrenom())) {
            boolean v = ps.ajouterunProfesseur(professeur.getNom(), professeur.getPrenom(),
                    professeur.getMatiere().getNom(),
                    professeur.getGrade());
            if (v) {
                return "professeur ajoute";
            } else {
                return "matiere introuvable";
            }

        }
        return "professeur deja enregistre";

    }

}
