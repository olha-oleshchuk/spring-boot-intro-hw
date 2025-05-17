package mate.academy.dao.shoppingCart;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class AddCartItemRequestDto {
    @NotNull
    private Long bookId;
    @NotNull
    @Positive
    private int quantity;
}
