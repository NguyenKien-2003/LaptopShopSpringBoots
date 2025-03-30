package com.hunre.edu.laptop.dtos.requests;

import com.hunre.edu.laptop.models.enums.Gender;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductUpdatetion {
    private String name;
    private String description;
    private int price;
    private Long categoryId;
    private Long brandId;
    private Gender gender;
}
