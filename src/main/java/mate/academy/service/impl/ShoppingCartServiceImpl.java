package mate.academy.service.impl;

import lombok.RequiredArgsConstructor;
import mate.academy.dao.shoppingCart.ShoppingCartResponseDto;
import mate.academy.exception.EntityNotFoundException;
import mate.academy.mapper.ShoppingCartMapper;
import mate.academy.model.CartItem;
import mate.academy.model.ShoppingCart;
import mate.academy.model.User;
import mate.academy.repository.ShoppingCartRepository;
import mate.academy.service.ShoppingCartService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartMapper shoppingCartMapper;
    private final ShoppingCartRepository shoppingCartRepository;

    @Override
    public void createShoppingCart(User user) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUser(user);
        shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public ShoppingCartResponseDto getShoppingCartForCurrentUser(Long userId) {
        return shoppingCartMapper.toDto(shoppingCartRepository.findByUserId(userId));
    }

    @Override
    public ShoppingCartResponseDto addItemToCart(Long userId, Long bookId, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }

        ShoppingCart currentshoppingCart = shoppingCartRepository.findByUserId(userId);
        CartItem currentCartItem = shoppingCartRepository.findCartItemByUserIdAndBookId(userId, bookId);
        if (currentCartItem == null) {
            throw new EntityNotFoundException("Can't find cart item by book id " + bookId);
        }
        currentCartItem.setQuantity(quantity);
        shoppingCartRepository.save(currentCartItem);
        currentshoppingCart.getCartItem().add(currentCartItem);
        return shoppingCartMapper.toDto(currentshoppingCart);
    }

    @Override
    public ShoppingCartResponseDto updateCartItemQuantity(Long shoppingCartId,
                                                          Long cartItemId,
                                                          int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }

        ShoppingCart currentShoppingCart = shoppingCartRepository.findById(shoppingCartId)
                .orElseThrow(() -> new EntityNotFoundException("Can't find shopping cart by id " + shoppingCartId));
        CartItem currentCartItem = shoppingCartRepository.findByCartItemId(cartItemId);
        currentCartItem.setQuantity(quantity);
        shoppingCartRepository.save(currentCartItem);
        return shoppingCartMapper.toDto(currentShoppingCart);
    }

    @Override
    public void deleteCartItem(Long shoppingCartId, Long cartItemId) {
        if (!shoppingCartRepository.existsById(shoppingCartId)) {
            throw new EntityNotFoundException("Can't find shopping cart by id " + shoppingCartId);
        }
        shoppingCartRepository.deleteByCartItemId(cartItemId);
    }
}
