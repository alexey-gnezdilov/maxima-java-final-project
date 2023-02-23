package ru.gnezdilov.spring.SecurityApp.services;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.gnezdilov.spring.SecurityApp.repositories.PeopleRepository;

@Service
@AllArgsConstructor
public class PersonDetailsService implements UserDetailsService {

    private final PeopleRepository peopleRepository;

    @Override
    public UserDetails loadUserByUsername(String fullName) throws UsernameNotFoundException {
        return peopleRepository
                .findByFullName(fullName)
                .orElseThrow(() -> new UsernameNotFoundException(""));
    }
}
