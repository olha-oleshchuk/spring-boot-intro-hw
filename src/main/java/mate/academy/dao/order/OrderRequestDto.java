package mate.academy.dao.order;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class OrderRequestDto {
    @NotBlank
    private String shippingAddress;
}

