package com.notexor.notex.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@Getter
@Setter
@Data
@Entity
public class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long compteId;
    private String email;
    private String password;
    private boolean isAcive;
    private boolean isLocked = false;
    @OneToOne(mappedBy = "compte")
    @ToString.Exclude
    @JsonIgnore
    private Personne personne;

    @Enumerated(EnumType.STRING)
    private Role role;

    public Compte(String email, String password, Personne personne) {
        this.email = email;
        this.password = password;
        this.personne = personne;
    }

    public void setRole(Role role) {
        role = null;
        if (personne.getClass() == Professeur.class) {
            this.role = Role.PROF;
        }
        if (personne.getClass() == Student.class) {
            this.role = Role.STUD;
        }
    }

    // @Override
    // public Collection<? extends GrantedAuthority> getAuthorities() {
    // // TODO Auto-generated method stub
    // return null;
    // }

    // @Override
    // public String getUsername() {
    // // TODO Auto-generated method stub
    // return email;
    // }

    // @Override
    // public boolean isAccountNonExpired() {
    // // TODO Auto-generated method stub
    // return true;
    // }

    // @Override
    // public boolean isAccountNonLocked() {
    // // TODO Auto-generated method stub
    // return !isLocked;
    // }

    // @Override
    // public boolean isCredentialsNonExpired() {
    // // TODO Auto-generated method stub
    // return true;
    // }

    // @Override
    // public boolean isEnabled() {
    // // TODO Auto-generated method stub
    // return true;
    // }

}
