package com.hunre.edu.laptop.dtos.responses;

import com.hunre.edu.laptop.models.User;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CartResponse {
    Long id;
    User user;
    Set<CartItemResponse> cartItemResponses = new HashSet<>();
    int totalPrice;
}
