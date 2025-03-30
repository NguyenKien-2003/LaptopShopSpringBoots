package com.hunre.edu.laptop.services;

import java.util.List;

import com.hunre.edu.laptop.models.HistoryUpdateOrder;

public interface HistoryUpdateOrderService {
    HistoryUpdateOrder createHistoryUpdateOrder(HistoryUpdateOrder historyUpdateOrder);
    List<HistoryUpdateOrder> getByOrderId(Long orderId);
}
