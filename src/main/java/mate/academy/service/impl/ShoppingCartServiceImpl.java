package mate.academy.service.impl;

import java.util.HashSet;
import lombok.RequiredArgsConstructor;
import mate.academy.dao.shoppingcart.ShoppingCartResponseDto;
import mate.academy.exception.EntityNotFoundException;
import mate.academy.mapper.CartItemMapper;
import mate.academy.mapper.ShoppingCartMapper;
import mate.academy.model.Book;
import mate.academy.model.CartItem;
import mate.academy.model.ShoppingCart;
import mate.academy.model.User;
import mate.academy.repository.BookRepository;
import mate.academy.repository.CartItemRepository;
import mate.academy.repository.ShoppingCartRepository;
import mate.academy.service.ShoppingCartService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartMapper shoppingCartMapper;
    private final ShoppingCartRepository shoppingCartRepository;
    private final CartItemRepository cartItemRepository;
    private final BookRepository bookRepository;
    private final CartItemMapper cartItemMapper;

    @Override
    public void createShoppingCart(User user) {
        if (shoppingCartRepository.findByUserId(user.getId()).isPresent()) {
            return;
        }
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUser(user);
        shoppingCart.setCartItem(new HashSet<>());
        shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public ShoppingCartResponseDto getShoppingCartForCurrentUser(Long userId) {
        ShoppingCart cart = shoppingCartRepository.findByUserId(userId)
                .orElseThrow(() -> new EntityNotFoundException("Shopping "
                        + "cart not found for user id " + userId));
        return shoppingCartMapper.toDto(cart);
    }

    @Override
    public ShoppingCartResponseDto addItemToCart(Long userId, Long bookId, int quantity) {
        ShoppingCart currentShoppingCart = shoppingCartRepository.findByUserId(userId)
                .orElseThrow(() -> new EntityNotFoundException("Shopping"
                        + "cart not found for user id " + userId));
        CartItem currentCartItem = cartItemRepository.findCartItemByUserIdAndBookId(userId, bookId);
        if (currentCartItem == null) {
            Book book = bookRepository.findById(bookId)
                    .orElseThrow(() -> new EntityNotFoundException("Can't find book by id "
                            + bookId));
            currentCartItem = cartItemMapper.toEntity(book, currentShoppingCart, quantity);
        } else {
            currentCartItem.setQuantity(currentCartItem.getQuantity() + quantity);
        }
        cartItemRepository.save(currentCartItem);
        return shoppingCartMapper.toDto(currentShoppingCart);
    }

    @Override
    public ShoppingCartResponseDto updateCartItemQuantity(Long shoppingCartId,
                                                          Long cartItemId,
                                                          int quantity) {
        CartItem currentCartItem = cartItemRepository
                .findByIdAndShoppingCartId(cartItemId, shoppingCartId)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Can't find cart item with id " + cartItemId
                                + " in shopping cart with id " + shoppingCartId));
        ShoppingCart cart = currentCartItem.getShoppingCart();
        currentCartItem.setQuantity(quantity);
        cartItemRepository.save(currentCartItem);
        return shoppingCartMapper.toDto(cart);
    }

    @Override
    public void deleteCartItem(Long shoppingCartId, Long cartItemId) {
        CartItem currentCartItem = cartItemRepository
                .findByIdAndShoppingCartId(cartItemId, shoppingCartId)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Can't find cart item with id " + cartItemId
                                + " in shopping cart with id " + shoppingCartId));
        ShoppingCart cart = currentCartItem.getShoppingCart();
        cartItemRepository.deleteByCartItemId(cartItemId);
        cart.getCartItem().remove(currentCartItem);
        shoppingCartRepository.save(cart);
    }
}
