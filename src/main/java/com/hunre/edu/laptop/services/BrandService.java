package com.hunre.edu.laptop.services;

import com.hunre.edu.laptop.dtos.responses.ResponseMessage;
import com.hunre.edu.laptop.models.Brand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BrandService {
    boolean existsByName(String name);
    Brand findByName(String name);
    ResponseMessage create(Brand brand);
    ResponseMessage update(Brand brand, Long id);
    ResponseMessage delete(Long id);
    Brand getById(Long id);
    Page<Brand> getAll(String name, Pageable pageable);
}
