package com.hunre.edu.laptop.services;

import com.hunre.edu.laptop.dtos.requests.CartRequest;
import com.hunre.edu.laptop.dtos.requests.OrderNowCreation;
import com.hunre.edu.laptop.dtos.responses.CartResponse;
import com.hunre.edu.laptop.dtos.responses.ResponseMessage;
import com.hunre.edu.laptop.models.Cart;

public interface CartService {
    CartResponse getCartByUser(String username);
    ResponseMessage addToCart(String username, CartRequest cartRequest);
    ResponseMessage updateCart(String username, Long cartItemId, int quantity);
    ResponseMessage removeFromCart(String username, Long cartItemId);
    ResponseMessage clearCart(String username);
    Integer getCartTotal(String username);
    ResponseMessage addCartNow(String username, OrderNowCreation orderNowCreation);
}
