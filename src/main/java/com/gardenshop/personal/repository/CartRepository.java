package com.gardenshop.personal.repository;

import com.gardenshop.personal.model.cart.Cart;
import com.gardenshop.personal.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Optional<Cart> findByUser(User user); // ✅ теперь всё работает
}
