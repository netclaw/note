package com.notexor.notex.model;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Embeddable
public class NotePk implements Serializable {
    @OneToOne
    @JoinColumn(name = "studentId", referencedColumnName = "matricule")
    private Student student;
    @OneToOne
    private Matiere matiere;

}
