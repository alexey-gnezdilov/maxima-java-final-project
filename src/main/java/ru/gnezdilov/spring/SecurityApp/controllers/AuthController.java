package ru.gnezdilov.spring.SecurityApp.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gnezdilov.spring.SecurityApp.dto.PersonDTO;
import ru.gnezdilov.spring.SecurityApp.mappers.PersonMapper;
import ru.gnezdilov.spring.SecurityApp.models.Person;
import ru.gnezdilov.spring.SecurityApp.services.RegistrationService;
import ru.gnezdilov.spring.SecurityApp.util.PersonValidator;

@Controller
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private final PersonValidator personValidator;
    private final RegistrationService registrationService;
    private final PersonMapper personMapper;

    @GetMapping("/login")
    public String loginPage() {
        return "auth/login";
    }

    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("personDTO") PersonDTO personDTO) {
        return "auth/registration";
    }

    @PostMapping("/registration")
    public String performRegistration(@ModelAttribute("personDTO") @Valid PersonDTO personDTO,
                                      BindingResult bindingResult){
        Person person = personMapper.toEntity(personDTO);
        personValidator.validate(person, bindingResult);
        if (bindingResult.hasErrors())
            return "/auth/registration";
        registrationService.register(person);
        return "redirect:/auth/login";
    }
}
