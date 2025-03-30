package com.hunre.edu.laptop.dtos.requests;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginForm {
    private String username;
    private String password;
}
