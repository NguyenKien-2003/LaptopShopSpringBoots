package com.hunre.edu.laptop.repositories;

import com.hunre.edu.laptop.models.Order;
import com.hunre.edu.laptop.models.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    Set<OrderItem> findByOrder(Order order);
    boolean existsByProductVariantId(Long id);
    void deleteByProductVariantId(Long id);
}
