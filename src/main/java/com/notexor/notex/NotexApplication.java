package com.notexor.notex;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.notexor.notex.model.Grade;
import com.notexor.notex.repository.MatiereRepository;
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

	}

}
