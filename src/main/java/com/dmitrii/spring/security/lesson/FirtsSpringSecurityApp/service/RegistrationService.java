package com.dmitrii.spring.security.lesson.FirtsSpringSecurityApp.service;

import com.dmitrii.spring.security.lesson.FirtsSpringSecurityApp.model.People;
import com.dmitrii.spring.security.lesson.FirtsSpringSecurityApp.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : Dmitrii Frolov, a.k.a. A1Rinzler
 * @created : 24.07.2026
 **/

@Service
public class RegistrationService{

    private final PeopleRepository peopleRepository;
    private final PasswordEncoder bCryptPasswordEncoder;


    @Autowired
    public RegistrationService(PeopleRepository peopleRepository, PasswordEncoder bCryptPasswordEncoder) {
        this.peopleRepository = peopleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Transactional
    public void save(People people){
        people.setPassword(bCryptPasswordEncoder.encode(people.getPassword()));
        peopleRepository.save(people);
    }
}
