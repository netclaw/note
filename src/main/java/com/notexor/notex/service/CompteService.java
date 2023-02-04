package com.notexor.notex.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.notexor.notex.model.Compte;
import com.notexor.notex.repository.CompteRepository;

@Service
public class CompteService implements UserDetailsService {

    @Autowired
    CompteRepository cr;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Compte> ocompte = cr.findByEmail(email);
        if (ocompte.isEmpty()) {
            throw new UsernameNotFoundException("email not found");
        }
        Compte compte = ocompte.get();
        return compte;
    }

}
