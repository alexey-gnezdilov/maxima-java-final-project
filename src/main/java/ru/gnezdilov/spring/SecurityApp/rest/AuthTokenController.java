//package ru.gnezdilov.spring.SecurityApp.controllers;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import ru.gnezdilov.spring.SecurityApp.requests.AuthentificationRequest;
//import ru.gnezdilov.spring.SecurityApp.requests.RegisterRequest;
//import ru.gnezdilov.spring.SecurityApp.responses.AuthentificationResponse;
//import ru.gnezdilov.spring.SecurityApp.services.AuthentificationService;
//
//@RestController
//@RequestMapping("/api/v1/auth")
//@RequiredArgsConstructor
//public class AuthTokenController {
//
//    private final AuthentificationService service;
//
//    @PostMapping("/register")
//    public ResponseEntity<AuthentificationResponse> register (
//            @RequestBody RegisterRequest request) {
//        return ResponseEntity.ok(service.register(request));
//    }
//
//    @PostMapping("/authenticate")
//    public ResponseEntity<AuthentificationResponse> authenticate (
//            @RequestBody AuthentificationRequest request) {
//        return ResponseEntity.ok(service.authenticate(request));
//    }
//}
