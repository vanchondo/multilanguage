package com.veanchondo.multilanguage.services;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veanchondo.multilanguage.models.Label;
import com.veanchondo.multilanguage.models.LabelRequest;
import com.veanchondo.multilanguage.models.Language;
import com.veanchondo.multilanguage.repositories.LabelRepository;
import com.veanchondo.multilanguage.repositories.LanguageRepository;

import javassist.tools.web.BadHttpRequest;

@Service
public class LanguageService {

    @Autowired
    LanguageRepository languageRepository;

    @Autowired
    LabelRepository labelRepository;

    public Language findByLanguage(String language){
        Language lang = languageRepository.findByLanguage(language);
        if (lang!= null) {
            lang.setLabels(labelRepository.findByLanguageLanguage(language));
        }
        return lang;
    }

    public Language saveLanguage(String language){
        Language lang = new Language();
        lang.setLanguage(language);
        return languageRepository.save(lang);
    }

    public Language addLabel(LabelRequest label) throws BadHttpRequest{
        validateLabelRequest(label);
        Language language = findByLanguage(label.getLanguage());
        if (language == null){
            language = saveLanguage(label.getLanguage());
        }
        Label lbl = new Label();
        lbl.setLabelKey(label.getLabelKey());
        lbl.setLabelValue(label.getLabelValue());
        lbl.setLanguage(language);

        labelRepository.save(lbl);

        return findByLanguage(label.getLanguage());
    }

    private void validateLabelRequest(LabelRequest labelRequest) throws BadHttpRequest{
        if (labelRequest==null || StringUtils.isEmpty(labelRequest.getLabelKey()) || StringUtils.isEmpty(labelRequest.getLabelValue())){
            throw new BadHttpRequest();
        }
    }
}
