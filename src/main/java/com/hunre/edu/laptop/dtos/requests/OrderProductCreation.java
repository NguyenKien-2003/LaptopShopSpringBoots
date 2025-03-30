package com.hunre.edu.laptop.dtos.requests;

import com.hunre.edu.laptop.models.ProductVariant;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderProductCreation {
    Long productVariantId;
    int quantity;
    int price;
}
