package com.notionlike.note_service.controller;

import com.notionlike.note_service.model.Note;
import com.notionlike.note_service.service.NoteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    private final NoteService service;

    public NoteController(NoteService service) {
        this.service = service;
    }

    // Simulated user for now
    private final Long MOCK_USER_ID = 1L;

    @GetMapping
    public List<Note> getAllNotes() {
        return service.getAllNotes(MOCK_USER_ID);
    }

    @GetMapping("/{id}")
    public Note getNoteById(@PathVariable Long id) {
        return service.getNoteById(id);
    }

    @PostMapping
    public Note createNote(@RequestBody Note note) {
        note.setUserId(MOCK_USER_ID);
        return service.createNote(note);
    }

    @PutMapping("/{id}")
    public Note updateNote(@PathVariable Long id, @RequestBody Note note) {
        note.setUserId(MOCK_USER_ID);
        return service.updateNote(id, note);
    }

    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable Long id) {
        service.deleteNote(id);
    }
}
