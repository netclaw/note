package com.notexor.notex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notexor.notex.model.Matiere;
import com.notexor.notex.service.MatiereService;

@RestController
@RequestMapping("matieres")
public class MatiereController {

    @Autowired
    MatiereService ms;

    @PostMapping("add")
    public String ajouterMatiere(@RequestBody Matiere matiere) {
        if (ms.isMatiereNotRegistered(matiere.getNom())) {
            ms.ajouterMatiere(matiere.getNom(), matiere.getVolumeHoraire(), matiere.getSemestre());
            return "matiere ajoute";
        }
        return "matiere deja enregistre";

    }

}
