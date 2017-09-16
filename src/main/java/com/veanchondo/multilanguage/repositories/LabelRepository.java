package com.veanchondo.multilanguage.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.veanchondo.multilanguage.models.Label;

@Repository
public interface LabelRepository extends CrudRepository<Label, String>{

    List<Label> findByLanguageLanguage(String language);
}
