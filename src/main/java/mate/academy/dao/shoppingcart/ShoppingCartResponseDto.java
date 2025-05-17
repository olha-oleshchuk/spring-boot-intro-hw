package mate.academy.dao.shoppingcart;

import java.util.Set;
import mate.academy.model.CartItem;
import mate.academy.model.User;

public class ShoppingCartResponseDto {
    private Long id;
    private User userId;
    private Set<CartItem> cartItem;
}
