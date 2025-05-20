package mate.academy.dao.shoppingcart;

import java.util.Set;

public class ShoppingCartResponseDto {
    private Long id;
    private Long userId;
    private Set<CartItemResponseDto> cartItem;
}
