package com.hunre.edu.laptop.models.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum Gender {
    MALE, FEMALE, UNISEX
}

