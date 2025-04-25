package com.notionlike.note_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.notionlike.note_service.model.Note;

public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> findByUserId(Long userId);
}
