package com.cdac.Acts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdac.Acts.entities.GlobalDatabase;

@Repository
public interface GlobalDatabaseRepository extends JpaRepository<GlobalDatabase, Long> {
    List<GlobalDatabase> findBySentenceLanguage_LanguageId(Long languageId);
    List<GlobalDatabase> findByTranslationLanguage_LanguageId(Long languageId);;
}
