package com.notexor.notex.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notexor.notex.model.Student;
import com.notexor.notex.service.StudentService;

@RestController
@RequestMapping("students")
public class StudentController {

    @Autowired
    StudentService ss;

    @PostMapping("add")
    public String ajouterEtudiant(@RequestBody Student student) {

        ss.ajouterUnEtudiant(student.getNom(), student.getPrenom(), student.getDateNaissance(), student.getNiveau());
        return "etudiant ajoute";

    }

}
