package com.notexor.notex.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notexor.notex.model.Matiere;
import com.notexor.notex.model.Professeur;
import com.notexor.notex.repository.MatiereRepository;
import com.notexor.notex.repository.ProfesseurRepository;

@Service
public class MatiereService {
    @Autowired
    MatiereRepository mr;

    @Autowired
    ProfesseurRepository pr;

    public Matiere ajouterMatiere(String nom, int VolumeHoraire, int semestre) {
        Matiere matiere = new Matiere(nom, VolumeHoraire, semestre);
        return mr.save(matiere);
    }

    public boolean isMatiereNotRegistered(String nomMatiere) {
        Optional<Matiere> om = mr.findByNom(nomMatiere);
        if (om.isEmpty()) {
            return true;
        }
        return false;
    }

}
