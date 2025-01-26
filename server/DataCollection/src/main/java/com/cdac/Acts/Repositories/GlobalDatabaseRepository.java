package com.cdac.Acts.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdac.Acts.entities.GlobalDatabase;

@Repository
public interface GlobalDatabaseRepository extends JpaRepository<GlobalDatabase, Long> {
    List<GlobalDatabase> findBySentenceLanguageId(Long languageId);
    List<GlobalDatabase> findByTranslationLanguageId(Long translationLanguageId);
}
