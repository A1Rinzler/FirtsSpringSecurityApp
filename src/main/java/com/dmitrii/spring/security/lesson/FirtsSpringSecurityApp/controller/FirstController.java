package com.dmitrii.spring.security.lesson.FirtsSpringSecurityApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author : Dmitrii Frolov, a.k.a. A1Rinzler
 * @created : 09.07.2026
 **/
@Controller
@RequestMapping("/first")
public class FirstController {
    @GetMapping("")
    public String firstOne(){
        return "firstPage";
    }
}
