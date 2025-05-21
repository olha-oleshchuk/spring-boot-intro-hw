package mate.academy.dao.order;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import mate.academy.model.Order;

@Data
public class OrderUpdateDto {
    @NotNull
    private Order.Status status;
}

