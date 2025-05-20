package mate.academy.dao.order;

import jakarta.validation.constraints.NotNull;
import mate.academy.dao.shoppingcart.ShoppingCartResponseDto;
import mate.academy.model.Order;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderResponseDto {
    @NotNull
    private ShoppingCartResponseDto shoppingCartResponseDto;

    @NotNull
    private Order.Status status;

    @NotNull
    private BigDecimal total;

    @NotNull
    private LocalDateTime orderDate;
}
