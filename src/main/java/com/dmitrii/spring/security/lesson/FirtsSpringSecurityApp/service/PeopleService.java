package com.dmitrii.spring.security.lesson.FirtsSpringSecurityApp.service;

import com.dmitrii.spring.security.lesson.FirtsSpringSecurityApp.model.People;
import com.dmitrii.spring.security.lesson.FirtsSpringSecurityApp.repository.PeopleRepository;
import com.dmitrii.spring.security.lesson.FirtsSpringSecurityApp.security.PeopleDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author : Dmitrii Frolov, a.k.a. A1Rinzler
 * @created : 15.07.2026
 **/

@Service
public class PeopleService implements UserDetailsService {
    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<People> people = peopleRepository.findByUsername(username);
        if (people.isEmpty())
            throw new UsernameNotFoundException("Not found this user");
        return new PeopleDetails(people.get());
    }
}
