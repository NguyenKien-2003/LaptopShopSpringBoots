package com.hunre.edu.laptop.services;

import com.hunre.edu.laptop.dtos.requests.SeasonalDiscountCreation;
import com.hunre.edu.laptop.dtos.responses.ResponseMessage;
import com.hunre.edu.laptop.dtos.responses.SeasonalDiscountResponse;
import com.hunre.edu.laptop.models.SeasonalDiscount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SeasonalDiscountService {
    SeasonalDiscount createSeasonalDiscount(SeasonalDiscountCreation discount);
    SeasonalDiscount updateSeasonalDiscount(Long id, SeasonalDiscountCreation updatedDiscount);
    ResponseMessage deleteSeasonalDiscount(Long id);
    List<SeasonalDiscount> getActiveDiscounts();
    SeasonalDiscount getDiscountById(Long id);
    Page<SeasonalDiscountResponse> getAllDiscounts(String keyword, String status, Pageable pageable);
    SeasonalDiscountResponse getDiscountResponseById(Long id);
}
