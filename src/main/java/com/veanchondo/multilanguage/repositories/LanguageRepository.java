package com.veanchondo.multilanguage.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.veanchondo.multilanguage.models.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language, String>{
    Language findByLanguage(String language);

    List<Language> findAll();
}
