package com.notexor.notex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.notexor.notex.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
