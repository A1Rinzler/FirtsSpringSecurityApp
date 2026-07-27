package com.dmitrii.spring.security.lesson.FirtsSpringSecurityApp.util;

import com.dmitrii.spring.security.lesson.FirtsSpringSecurityApp.model.People;
import com.dmitrii.spring.security.lesson.FirtsSpringSecurityApp.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author : Dmitrii Frolov, a.k.a. A1Rinzler
 * @created : 24.07.2026
 **/

@Component
public class PeopleValidator implements Validator {

    private final PeopleService peopleService;

    @Autowired
    public PeopleValidator(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return People.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        People people = (People) target;
        try {
            peopleService.loadUserByUsername(people.getUsername());
        }
        catch (UsernameNotFoundException exception){
            return;
        }
        errors.rejectValue("username", "","Имя занятно");

    }
}
