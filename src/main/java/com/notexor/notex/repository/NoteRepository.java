package com.notexor.notex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.notexor.notex.model.Note;
import com.notexor.notex.model.NotePk;

public interface NoteRepository extends JpaRepository<Note, NotePk> {

}
