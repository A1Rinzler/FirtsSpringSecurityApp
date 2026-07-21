package com.dmitrii.spring.security.lesson.FirtsSpringSecurityApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author : Dmitrii Frolov, a.k.a. A1Rinzler
 * @created : 21.07.2026
 **/
@Controller
@RequestMapping("")
public class LoginController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
