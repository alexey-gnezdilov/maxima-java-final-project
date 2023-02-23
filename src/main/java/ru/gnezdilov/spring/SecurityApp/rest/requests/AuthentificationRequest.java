package ru.gnezdilov.spring.SecurityApp.rest.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthentificationRequest {

    private String fullName;
    private String password;

}
