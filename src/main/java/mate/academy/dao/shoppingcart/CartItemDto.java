package mate.academy.dao.shoppingcart;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class CartItemDto {
    @Positive
    private Long bookId;
    @NotNull
    private Long cartId;
    @Positive
    private int quantity;
}
