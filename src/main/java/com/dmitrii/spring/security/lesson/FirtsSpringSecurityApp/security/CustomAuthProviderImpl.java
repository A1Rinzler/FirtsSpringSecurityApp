package com.dmitrii.spring.security.lesson.FirtsSpringSecurityApp.security;

import com.dmitrii.spring.security.lesson.FirtsSpringSecurityApp.service.PeopleService;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collections;

/**
 * @author : Dmitrii Frolov, a.k.a. A1Rinzler
 * @created : 13.07.2026
 **/
//Класс был для теста кастомной аутентификации. Пока не нужен. Удалять не буду, но он не используется в дальнейшем.
//@Component
public class CustomAuthProviderImpl implements AuthenticationProvider {

    private final PeopleService peopleService;

    //@Autowired
    public CustomAuthProviderImpl(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @Override
    public @Nullable Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        UserDetails peopleDetails = peopleService.loadUserByUsername(username);
        String password = authentication.getCredentials().toString();
        if (!password.equals(peopleDetails.getPassword()))
            throw new BadCredentialsException("Incorrect password");
        return new UsernamePasswordAuthenticationToken(peopleDetails, password, Collections.emptyList());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
