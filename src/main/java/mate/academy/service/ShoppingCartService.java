package mate.academy.service;

import mate.academy.dao.shoppingcart.ShoppingCartResponseDto;
import mate.academy.model.User;

public interface ShoppingCartService {
    void createShoppingCart(User user);

    ShoppingCartResponseDto getShoppingCartForCurrentUser(Long userId);

    ShoppingCartResponseDto addItemToCart(Long userId, Long bookId, int quantity);

    ShoppingCartResponseDto updateCartItemQuantity(Long shoppingCartId,
                                                   Long cartItemId,
                                                   int quantity);

    ShoppingCartResponseDto deleteCartItem(Long shoppingCartId, Long cartItemId);
}
