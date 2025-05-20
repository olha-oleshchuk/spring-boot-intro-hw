package mate.academy.mapper;

import mate.academy.config.MapperConfig;
import mate.academy.dao.shoppingcart.CartItemDto;
import mate.academy.model.Book;
import mate.academy.model.CartItem;
import mate.academy.model.ShoppingCart;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface CartItemMapper {
    CartItem toEntity(CartItemDto cartItemDto);

    default CartItem toEntity(Book book, ShoppingCart cart, int quantity) {
        CartItem cartItem = new CartItem();
        cartItem.setBook(book);
        cartItem.setShoppingCart(cart);
        cartItem.setQuantity(quantity);
        return cartItem;
    }
}