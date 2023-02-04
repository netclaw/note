package com.notexor.notex.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.notexor.notex.model.Compte;
import com.notexor.notex.model.Professeur;
import com.notexor.notex.repository.CompteRepository;

@Service
public class CompteService implements UserDetailsService {

    @Autowired
    CompteRepository cr;

    @Value("${notes.admin.nom}")
    private String nomAdmin;

    @Value("${notes.admin.prenom}")
    private String prenomAdmin;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Compte> ocompte = cr.findByEmail(email);
        if (ocompte.isEmpty()) {
            throw new UsernameNotFoundException("email not found");
        }
        Compte compte = ocompte.get();
        UserDetails user;
        if (compte.getPersonne().getNom().equals(nomAdmin.substring(1,
                nomAdmin.length() - 1))
                && compte.getPersonne().getPrenom().equals(prenomAdmin.substring(1,
                        prenomAdmin.length() - 1))) {
            user = User.withUsername(compte.getEmail()).password(compte.getPassword())
                    .authorities("ADMIN")
                    .build();

        } else {
            user = User.withUsername(compte.getEmail()).password(compte.getPassword())
                    .authorities(compte.getRole().toString())
                    .build();

        }

        return user;
    }

}
