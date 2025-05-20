package mate.academy.mapper;

import mate.academy.model.Book;
import mate.academy.model.CartItem;
import mate.academy.model.ShoppingCart;
import org.springframework.stereotype.Component;

@Component
public class CartItemMapper {
    public CartItem toEntity(Book book, ShoppingCart cart, int quantity) {
        CartItem cartItem = new CartItem();
        cartItem.setBook(book);
        cartItem.setShoppingCart(cart);
        cartItem.setQuantity(quantity);
        return cartItem;
    }
}