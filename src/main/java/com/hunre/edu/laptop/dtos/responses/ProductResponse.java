package com.hunre.edu.laptop.dtos.responses;

import com.hunre.edu.laptop.models.Brand;
import com.hunre.edu.laptop.models.Category;
import com.hunre.edu.laptop.models.ProductVariant;
import com.hunre.edu.laptop.models.enums.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductResponse {
    Long id;
    String name;
    String description;
    int price;
    Brand brand;
    Category category;
    boolean status;
    Gender gender;
    List<ProductVariant> productVariants;
    int totalStock;
}
