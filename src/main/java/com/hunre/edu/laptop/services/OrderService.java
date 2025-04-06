package com.hunre.edu.laptop.services;

import com.hunre.edu.laptop.dtos.requests.OrderCreationByStaff;
import com.hunre.edu.laptop.dtos.requests.OrderNowCreation;
import com.hunre.edu.laptop.dtos.requests.OrderProductCreation;
import com.hunre.edu.laptop.dtos.responses.OrderStats;
import com.hunre.edu.laptop.dtos.responses.ResponseMessage;
import com.hunre.edu.laptop.dtos.responses.Statuses;
import com.hunre.edu.laptop.models.Cart;
import com.hunre.edu.laptop.models.Order;
import com.hunre.edu.laptop.models.User;
import com.hunre.edu.laptop.models.enums.OrderStatus;
import com.hunre.edu.laptop.models.enums.OrderType;
import com.hunre.edu.laptop.models.enums.PaymentType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface OrderService {
    Order createOrder(String username, String voucherCode, PaymentType paymentType, String address);
    Order getOrderById(Long id);
    Page<Order> getOrdersByUser(Pageable pageable, String username);
    void updateOrderStatus(Long orderId, String status);
    void updateOrderPaid(Long orderId);
    List<Order> getAllOrdersExcel();
    Page<Order> getAllOrders(Pageable pageable, String keyword, LocalDate startDate, LocalDate endDate);
    Order createOrderByStaff(String username, OrderCreationByStaff orderCreationByStaff);
    Order getOrderInfo(Long orderId);
    Order createOrderNow(String username, OrderNowCreation orderNowCreation);
    Order switchOrderStatus(Long orderId, String username);
    Page<Order> getOrderByOrderType(Pageable pageable, OrderType orderType);
    Page<Order> getOrderByStatus(OrderStatus status, String keyword, LocalDate startDate, LocalDate endDate, Pageable pageable);
    ResponseMessage deleteOrder(Long orderId);
    List<Statuses> getOrderStatuses();
    List<Statuses> getOrderStatusesForUser(String username);
    Page<Order> getOrdersByUserAndStatus(String username, OrderStatus status, Pageable pageable);
    ResponseMessage cancelOrder(Long orderId);
    Map<String, Object> getRevenueAndOrderData();
    Map<String, Object> getDailyRevenueData(LocalDate startDate, LocalDate endDate);


}
