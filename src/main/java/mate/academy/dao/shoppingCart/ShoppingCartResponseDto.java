package mate.academy.dao.shoppingCart;

import mate.academy.model.CartItem;
import mate.academy.model.User;
import java.util.Set;

public class ShoppingCartResponseDto {
    private Long id;
    private User userId;
    private Set<CartItem> cartItem;
}
