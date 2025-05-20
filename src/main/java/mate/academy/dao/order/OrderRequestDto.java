package mate.academy.dao.order;

import jakarta.validation.constraints.NotBlank;

public class OrderRequestDto {
    @NotBlank
    private String shippingAddress;
}
