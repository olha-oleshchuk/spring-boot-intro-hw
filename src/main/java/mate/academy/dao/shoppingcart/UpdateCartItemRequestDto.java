package mate.academy.dao.shoppingcart;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class UpdateCartItemRequestDto {
    @NotNull
    @Positive
    private Long cartItemId;

    @Positive
    private int quantity;
}
