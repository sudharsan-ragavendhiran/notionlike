package com.notionlike.folder_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.notionlike.folder_service.model.Folder;

public interface FolderRepository extends JpaRepository<Folder, Long> {
    List<Folder> findByUserId(Long userId);
}
