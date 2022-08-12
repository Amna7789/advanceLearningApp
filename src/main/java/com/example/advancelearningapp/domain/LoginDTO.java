package com.example.advancelearningapp.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class LoginDTO {
    String email;
    String password;
    Boolean login;
}
