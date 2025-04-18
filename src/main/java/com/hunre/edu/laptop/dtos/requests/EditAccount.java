package com.hunre.edu.laptop.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EditAccount {
    private String name;
    private String username;
    private String password;
    private String rePassword;
    private String email;
    private String phoneNumber;
    private Set<String> roles;
    private boolean status;
}
