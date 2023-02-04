package com.notexor.notex.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Data
public class Note {
    @EmbeddedId
    private NotePk noteId;
    private Double note;
    private String appreciation;
    @ManyToOne
    @JoinColumn(name = "matiereId", referencedColumnName = "matiereId")
    private Matiere matiere;
}
