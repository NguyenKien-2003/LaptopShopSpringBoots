package com.hunre.edu.laptop.dtos.responses;

import com.hunre.edu.laptop.models.ProductVariant;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SeasonalDiscountResponse {
    Long id;
    String name;
    int discountRate;
    LocalDate startDate;
    LocalDate endDate;
    String description;
    List<ProductVariant> applicableProducts;
    boolean status;
}
