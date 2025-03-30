package com.hunre.edu.laptop.dtos.responses;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductResponseAndRelate {
    ProductVariantDetailsResponse productVariantDetailsResponse;
    List<ProductVariantDetailsResponse> productVariantDetailsResponses;
}
