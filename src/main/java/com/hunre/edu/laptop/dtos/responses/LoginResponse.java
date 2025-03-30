package com.hunre.edu.laptop.dtos.responses;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginResponse {
    private String accessToken;
}
