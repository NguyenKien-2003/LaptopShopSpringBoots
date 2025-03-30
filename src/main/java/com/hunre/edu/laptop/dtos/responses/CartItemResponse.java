package com.hunre.edu.laptop.dtos.responses;

import com.hunre.edu.laptop.models.Cart;
import com.hunre.edu.laptop.models.ProductVariant;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CartItemResponse {
    Long id;
    ProductVariantDetailsResponse productVariantDetailsResponse;
    int quantity;
    int price;
}
