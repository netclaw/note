package com.notexor.notex.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notexor.notex.model.Student;
import com.notexor.notex.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository sr;

    public List<Student> afficherTousLesEtudiants() {
        return sr.findAll();
    }

    public Student ajouterUnEtudiant(String nom, String prenom, LocalDate dateNaissance, int niveau) {
        Student student = new Student(nom, prenom, dateNaissance, niveau);
        return sr.save(student);
    }

}
