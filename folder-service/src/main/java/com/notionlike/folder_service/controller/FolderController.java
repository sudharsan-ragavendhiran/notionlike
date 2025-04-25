package com.notionlike.folder_service.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notionlike.folder_service.model.Folder;
import com.notionlike.folder_service.service.FolderService;

@RestController
@RequestMapping("/api/folders")
public class FolderController {

    private final FolderService service;
    private final Long MOCK_USER_ID = 1L;

    public FolderController(FolderService service) {
        this.service = service;
    }

    @GetMapping
    public List<Folder> getFolders() {
        return service.getFoldersByUser(MOCK_USER_ID);
    }

    @PostMapping
    public Folder createFolder(@RequestBody Folder folder) {
        folder.setUserId(MOCK_USER_ID);
        return service.createFolder(folder);
    }

    @PutMapping("/{id}")
    public Folder updateFolder(@PathVariable Long id, @RequestBody Folder folder) {
        folder.setUserId(MOCK_USER_ID);
        return service.updateFolder(id, folder);
    }

    @DeleteMapping("/{id}")
    public void deleteFolder(@PathVariable Long id) {
        service.deleteFolder(id);
    }
}
