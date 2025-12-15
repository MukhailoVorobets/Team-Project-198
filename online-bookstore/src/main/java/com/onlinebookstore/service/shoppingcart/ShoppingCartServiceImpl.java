package com.onlinebookstore.service.shoppingcart;

import com.onlinebookstore.dto.shoppingcart.AddToCartRequestDto;
import com.onlinebookstore.dto.shoppingcart.ShoppingCartDto;
import com.onlinebookstore.dto.shoppingcart.UpdateCartItemRequestDto;
import com.onlinebookstore.exception.EntityNotFoundException;
import com.onlinebookstore.mapper.CartItemMapper;
import com.onlinebookstore.mapper.ShoppingCartMapper;
import com.onlinebookstore.model.Book;
import com.onlinebookstore.model.CartItem;
import com.onlinebookstore.model.ShoppingCart;
import com.onlinebookstore.model.User;
import com.onlinebookstore.repository.CartItemRepository;
import com.onlinebookstore.repository.ShoppingCartRepository;
import com.onlinebookstore.repository.book.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;
    private final CartItemRepository cartItemRepository;
    private final BookRepository bookRepository;
    private final ShoppingCartMapper shoppingCartMapper;
    private final CartItemMapper cartItemMapper;

    @Override
    public ShoppingCartDto getShoppingCart(Long userId) {
        ShoppingCart shoppingCart = shoppingCartRepository.findByUserId(userId)
                .orElseThrow(() ->
                        new EntityNotFoundException("Shopping cart not found for user id: "
                                + userId));
        return shoppingCartMapper.toDto(shoppingCart);
    }

    @Override
    public ShoppingCartDto addCartItem(Long userId, AddToCartRequestDto request) {
        ShoppingCart shoppingCart = shoppingCartRepository.findByUserId(userId)
                .orElseThrow(() ->
                        new EntityNotFoundException("Shopping cart not found for user id: "
                                + userId));
        Book book = bookRepository.findById(request.bookId())
                .orElseThrow(() ->
                        new EntityNotFoundException("Book not  found with id: "
                                + request.bookId()));
        CartItem existingCartItem = cartItemRepository
                .findByBookIdAndShoppingCartId(request.bookId(), userId).orElse(null);

        if (existingCartItem != null) {
            existingCartItem.setQuantity(existingCartItem.getQuantity() + request.quantity());
            cartItemRepository.save(existingCartItem);
        } else {
            CartItem cartItem = cartItemMapper.toModel(request);
            cartItem.setShoppingCart(shoppingCart);
            cartItem.setBook(book);
            shoppingCart.getCartItems().add(cartItem);
        }
        return shoppingCartMapper.toDto(shoppingCartRepository.save(shoppingCart));
    }

    @Override
    public ShoppingCartDto updateCartItem(Long userId,
                                          Long cartItemId,
                                          UpdateCartItemRequestDto requestDto) {
        CartItem cartItem = cartItemRepository
                .findByIdAndShoppingCartId(cartItemId, userId)
                .orElseThrow(() -> new EntityNotFoundException("Cart item not found with id: "
                        + cartItemId));
        cartItem.setQuantity(requestDto.quantity());
        cartItemRepository.save(cartItem);
        return getShoppingCart(userId);
    }

    @Override
    public void deleteCartItem(Long userId,
                               Long cartItemId) {
        CartItem cartItem = cartItemRepository.findByIdAndShoppingCartId(cartItemId, userId)
                .orElseThrow(() -> new EntityNotFoundException("Cart item not found with id: "
                        + cartItemId));
        cartItemRepository.delete(cartItem);
    }

    @Override
    public void createShoppingCart(User user) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUser(user);
        shoppingCartRepository.save(shoppingCart);
    }
}
