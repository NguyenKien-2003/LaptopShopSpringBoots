package com.hunre.edu.laptop.repositories;

import com.hunre.edu.laptop.models.Cart;
import com.hunre.edu.laptop.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findByUser(User user);
}
