package com.onlinebookstore.service.shoppingcart;

import com.onlinebookstore.dto.shoppingcart.AddToCartRequestDto;
import com.onlinebookstore.dto.shoppingcart.ShoppingCartDto;
import com.onlinebookstore.dto.shoppingcart.UpdateCartItemRequestDto;
import com.onlinebookstore.model.User;

public interface ShoppingCartService {
    ShoppingCartDto getShoppingCart(Long userId);

    ShoppingCartDto addCartItem(Long userId, AddToCartRequestDto request);

    ShoppingCartDto updateCartItem(Long userId, Long cartItemId,
                                   UpdateCartItemRequestDto requestDto);

    void deleteCartItem(Long userId, Long cartItemId);

    void createShoppingCart(User user);
}
