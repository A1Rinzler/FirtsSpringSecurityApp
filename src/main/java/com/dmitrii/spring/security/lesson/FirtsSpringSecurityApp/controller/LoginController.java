package com.dmitrii.spring.security.lesson.FirtsSpringSecurityApp.controller;

import com.dmitrii.spring.security.lesson.FirtsSpringSecurityApp.model.People;
import com.dmitrii.spring.security.lesson.FirtsSpringSecurityApp.service.RegistrationService;
import com.dmitrii.spring.security.lesson.FirtsSpringSecurityApp.util.PeopleValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

/**
 * @author : Dmitrii Frolov, a.k.a. A1Rinzler
 * @created : 21.07.2026
 **/
@Controller
@RequestMapping("")
public class LoginController {
    private final PeopleValidator peopleValidator;
    private final RegistrationService registrationService;

    @Autowired
    public LoginController(PeopleValidator peopleValidator, RegistrationService registrationService) {
        this.peopleValidator = peopleValidator;
        this.registrationService = registrationService;
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/register")
    public String registerPage(Model model){
        model.addAttribute("person", new People());
        return "register";
    }

    @PostMapping("/registration")
    public String fromRegisterPage(@ModelAttribute ("person") @Valid People people , BindingResult bindingResult){
        peopleValidator.validate(people, bindingResult);
        if(bindingResult.hasErrors()){
            return "register";
        }
        registrationService.save(people);
        return "redirect:/login";
    }
}
