package com.hunre.edu.laptop.dtos.responses;

import com.hunre.edu.laptop.models.Product;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductVariantDetailsResponse {
    Long id;
    Product product;
    int size;
    String color;
    int stockQuantity;
    int price;
    int discountRate;
    int priceAfterDiscount;
    boolean defaultVariant;
    String imageAvatar;
    List<String> imageOthers;
    String qrCode;
    List<String> colors;
    List<Integer> sizes;
}
