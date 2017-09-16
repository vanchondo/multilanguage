package com.veanchondo.multilanguage.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.veanchondo.multilanguage.models.LabelRequest;
import com.veanchondo.multilanguage.models.Language;
import com.veanchondo.multilanguage.services.LanguageService;

@RestController
@RequestMapping("")
public class LanguageController {

    @Autowired
    LanguageService languageService;

    @GetMapping("")
    public Language getByLanguage(@RequestParam(value = "lang", required = true) String language){
        return languageService.findByLanguage(language);
    }

    @PostMapping("")
    public Language addKey(@RequestBody LabelRequest label) throws Exception{
        return languageService.addLabel(label);
    }
}
