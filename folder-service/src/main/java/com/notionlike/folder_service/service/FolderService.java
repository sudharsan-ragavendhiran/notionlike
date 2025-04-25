package com.notionlike.folder_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.notionlike.folder_service.model.Folder;
import com.notionlike.folder_service.repository.FolderRepository;

@Service
public class FolderService {

    private final FolderRepository repo;

    public FolderService(FolderRepository repo) {
        this.repo = repo;
    }

    public List<Folder> getFoldersByUser(Long userId) {
        return repo.findByUserId(userId);
    }

    public Folder createFolder(Folder folder) {
        return repo.save(folder);
    }

    public Folder updateFolder(Long id, Folder updated) {
        Folder folder = repo.findById(id).orElseThrow();
        folder.setName(updated.getName());
        return repo.save(folder);
    }

    public void deleteFolder(Long id) {
        repo.deleteById(id);
    }
}
