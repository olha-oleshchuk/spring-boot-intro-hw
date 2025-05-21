package mate.academy.dao.shoppingcart;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class CartItemDto {
    @NotNull
    @Positive
    private Long bookId;
    @NotNull
    @Positive
    private Long cartId;
    @Positive
    private int quantity;
}
