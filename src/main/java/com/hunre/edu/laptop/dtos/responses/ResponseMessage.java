package com.hunre.edu.laptop.dtos.responses;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseMessage {
    private int status;
    private String message;
}
