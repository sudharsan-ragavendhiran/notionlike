package com.notionlike.note_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.notionlike.note_service.model.Note;
import com.notionlike.note_service.repository.NoteRepository;

@Service
public class NoteService {

    private final NoteRepository repo;

    public NoteService(NoteRepository repo) {
        this.repo = repo;
    }

    public List<Note> getAllNotes(Long userId) {
        return repo.findByUserId(userId);
    }

    public Note getNoteById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Note createNote(Note note) {
        return repo.save(note);
    }

    public Note updateNote(Long id, Note updatedNote) {
        Note note = repo.findById(id).orElseThrow();
        note.setTitle(updatedNote.getTitle());
        note.setContent(updatedNote.getContent());
        note.setFolderId(updatedNote.getFolderId());
        return repo.save(note);
    }

    public void deleteNote(Long id) {
        repo.deleteById(id);
    }
}
