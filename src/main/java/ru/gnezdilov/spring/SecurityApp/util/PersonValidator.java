package ru.gnezdilov.spring.SecurityApp.util;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.gnezdilov.spring.SecurityApp.models.Person;
import ru.gnezdilov.spring.SecurityApp.services.PersonDetailsService;

@Component
@AllArgsConstructor
public class PersonValidator implements Validator {

    private final PersonDetailsService personDetailsService;

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Person person = (Person) o;
        try {
            personDetailsService.loadUserByUsername(person.getFullName());
        } catch (UsernameNotFoundException e) {
            return;
        }
        errors.rejectValue("fullName", "", "Человек уже существует");
    }
}
