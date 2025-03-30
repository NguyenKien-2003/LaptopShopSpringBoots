package com.hunre.edu.laptop.dtos.requests;

import com.hunre.edu.laptop.models.enums.OrderType;
import com.hunre.edu.laptop.models.enums.PaymentType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderCreationByStaff {
    Long customerId;
    List<OrderProductCreation> orderProductCreations;
    String voucherCode = "";
    OrderType orderType;
    PaymentType paymentType;
    String address;
}
