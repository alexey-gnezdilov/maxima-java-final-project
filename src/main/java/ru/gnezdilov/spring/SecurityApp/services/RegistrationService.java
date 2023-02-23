package ru.gnezdilov.spring.SecurityApp.services;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gnezdilov.spring.SecurityApp.models.Person;
import ru.gnezdilov.spring.SecurityApp.models.Role;
import ru.gnezdilov.spring.SecurityApp.repositories.PeopleRepository;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final PeopleRepository peopleRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void register(Person person) {
        person.setPassword(passwordEncoder.encode(person.getPassword()));
        person.setRole(Role.ROLE_USER);
        peopleRepository.save(person);
    }
}
