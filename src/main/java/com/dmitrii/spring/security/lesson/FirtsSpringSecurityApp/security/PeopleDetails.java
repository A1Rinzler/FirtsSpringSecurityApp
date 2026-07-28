package com.dmitrii.spring.security.lesson.FirtsSpringSecurityApp.security;

import com.dmitrii.spring.security.lesson.FirtsSpringSecurityApp.model.People;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author : Dmitrii Frolov, a.k.a. A1Rinzler
 * @created : 10.07.2026
 **/

public class PeopleDetails implements UserDetails {
    private People people;

    public PeopleDetails(People people) {
        this.people = people;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(people.getRole()));
    }

    @Override
    public @Nullable String getPassword() {
        return people.getPassword();
    }

    @Override
    public String getUsername() {
        return people.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
