package com.dmitrii.spring.security.lesson.FirtsSpringSecurityApp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

/**
 * @author : Dmitrii Frolov, a.k.a. A1Rinzler
 * @created : 09.07.2026
 **/
@Entity
@Table(name = "People")
public class People {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "This value shouldn`t be empty")
    @Size(message = "Value size from 1 to 20")
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;


    @Min(value = 1900, message = "Birthdate value starts from 1900 and above")
    @Column(name = "birthdate")
    private int birthdate;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(int birthdate) {
        this.birthdate = birthdate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public People(String username, int birthdate) {
        this.username = username;
        this.birthdate = birthdate;}

    public People() {
    }

    @Override
    public String toString() {
        return "Person { id = " + id + " username " + username + " password " + password + " birthdate " + birthdate ;
    }
}
