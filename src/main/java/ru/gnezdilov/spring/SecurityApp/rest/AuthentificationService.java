//package ru.gnezdilov.spring.SecurityApp.services;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//import ru.gnezdilov.spring.SecurityApp.models.Person;
//import ru.gnezdilov.spring.SecurityApp.models.Role;
//import ru.gnezdilov.spring.SecurityApp.repositories.PeopleRepository;
//import ru.gnezdilov.spring.SecurityApp.requests.AuthentificationRequest;
//import ru.gnezdilov.spring.SecurityApp.requests.RegisterRequest;
//import ru.gnezdilov.spring.SecurityApp.responses.AuthentificationResponse;
//
//@Service
//@RequiredArgsConstructor
//public class AuthentificationService {
//
//    private final PeopleRepository peopleRepository;
//    private final PasswordEncoder passwordEncoder;
//    private final JwtService jwtService;
//    private final AuthenticationManager authenticationManager;
//
//    public AuthentificationResponse register(RegisterRequest request) {
//        Person person = Person.builder()
//                .fullName(request.getFullName())
//                .yearOfBirth(request.getYearOfBirth())
//                .password(passwordEncoder.encode(request.getPassword()))
//                .role(Role.ROLE_USER)
//                .build();
//        peopleRepository.save(person);
//        String jwtToken = jwtService.generateToken(person);
//        return AuthentificationResponse.builder()
//                .token(jwtToken)
//                .build();
//    }
//
//    public AuthentificationResponse authenticate(AuthentificationRequest request) {
//        authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        request.getFullName(),
//                        request.getPassword()
//                )
//        );
//        Person person = peopleRepository.findByFullName(request.getFullName())
//                .orElseThrow();
//        String jwtToken = jwtService.generateToken(person);
//        return AuthentificationResponse.builder()
//                .token(jwtToken)
//                .build();
//    }
//}
