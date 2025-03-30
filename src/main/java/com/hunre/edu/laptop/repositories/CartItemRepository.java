package com.hunre.edu.laptop.repositories;

import com.hunre.edu.laptop.models.Cart;
import com.hunre.edu.laptop.models.CartItem;
import com.hunre.edu.laptop.models.ProductVariant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    Set<CartItem> findByCart(Cart cart);
    CartItem findByCartAndProductVariant(Cart cart, ProductVariant productVariant);
    void deleteByCart(Cart cart);
    boolean existsByProductVariantId(Long id);
    void deleteByProductVariantId(Long id);
}
