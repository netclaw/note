package com.notexor.notex;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.notexor.notex.model.Compte;
import com.notexor.notex.model.Grade;
import com.notexor.notex.model.Personne;
import com.notexor.notex.model.Role;
import com.notexor.notex.repository.CompteRepository;
import com.notexor.notex.repository.MatiereRepository;
import com.notexor.notex.repository.PersonneRepository;
import com.notexor.notex.repository.ProfesseurRepository;
import com.notexor.notex.service.MatiereService;
import com.notexor.notex.service.ProfesseurService;
import com.notexor.notex.service.StudentService;

@SpringBootApplication
public class NotexApplication {
	@Autowired
	StudentService ss;

	@Autowired
	MatiereService ms;

	@Autowired
	ProfesseurService ps;

	@Autowired
	MatiereRepository mr;

	@Autowired
	CompteRepository cr;

	@Autowired
	PersonneRepository pr;

	@Autowired
	ProfesseurRepository pror;

	public static void main(String[] args) {
		SpringApplication.run(NotexApplication.class, args);
	}

	@Bean
	public void CommandLineRunner() {
		System.out.println("DEBUT______TEST____________");
		System.out.println();

		ss.ajouterUnEtudiant("youssef", "berkia", LocalDate.parse("2001-09-09"), 2);

		ms.ajouterMatiere("math", 20, 1);
		ps.ajouterunProfesseur("kabaj", "issam", "math", Grade.PA);

		System.out.println();
		System.out.println(ps.isProfesseurNonEnregistre("kabaj", "issam"));

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		Compte compte = new Compte("ola", encoder.encode("xqc"),
				pr.findByNomAndPrenom("youssef", "berkia").get());
		Personne p = pr.findByNomAndPrenom("youssef", "berkia").get();
		p.setCompte(compte);
		compte.setRole(Role.STUD);
		pr.save(p);

		System.out.println("babek");
		System.out.println("babek");
		System.out.println(p);

		System.out.println();

		System.out.println();
		ps.afficherTousLesProfesseurs().forEach(System.out::println);
	}

}
