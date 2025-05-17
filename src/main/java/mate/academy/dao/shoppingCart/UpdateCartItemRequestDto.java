package mate.academy.dao.shoppingCart;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class UpdateCartItemRequestDto {
    @NotNull
    @Positive
    private int quantity;
}
