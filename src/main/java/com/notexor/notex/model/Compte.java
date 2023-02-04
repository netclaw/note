package com.notexor.notex.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long compteId;
    private String mail;
    private String password;
    private boolean isAcive;
    private boolean isLocked = false;
    @OneToOne(mappedBy = "compte")
    private Personne personne;

}
