package com.hunre.edu.laptop.services.impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hunre.edu.laptop.models.HistoryUpdateOrder;
import com.hunre.edu.laptop.repositories.HistoryUpdateOrderRepository;
import com.hunre.edu.laptop.services.HistoryUpdateOrderService;

@Service
public class HistoryUpdateOrderServiceImpl implements HistoryUpdateOrderService{
    @Autowired
    private HistoryUpdateOrderRepository historyUpdateOrderRepository;

    @Override
    public HistoryUpdateOrder createHistoryUpdateOrder(HistoryUpdateOrder historyUpdateOrder) {
        return historyUpdateOrderRepository.save(historyUpdateOrder);
    }

    @Override
    public List<HistoryUpdateOrder> getByOrderId(Long orderId) {
        return historyUpdateOrderRepository.findByOrder_Id(orderId);
    }
    
}
