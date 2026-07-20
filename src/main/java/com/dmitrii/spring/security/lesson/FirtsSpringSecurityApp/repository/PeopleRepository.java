package com.dmitrii.spring.security.lesson.FirtsSpringSecurityApp.repository;

import com.dmitrii.spring.security.lesson.FirtsSpringSecurityApp.model.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author : Dmitrii Frolov, a.k.a. A1Rinzler
 * @created : 15.07.2026
 **/

@Repository
public interface PeopleRepository extends JpaRepository<People, Integer> {
    Optional<People> findByUsername(String username);
}
