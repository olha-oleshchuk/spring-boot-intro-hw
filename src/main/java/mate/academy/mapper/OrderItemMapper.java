package mate.academy.mapper;

import mate.academy.config.MapperConfig;
import mate.academy.dao.order.OrderItemResponseDto;
import mate.academy.model.CartItem;
import mate.academy.model.OrderItem;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface OrderItemMapper {
    OrderItemResponseDto toDto(OrderItem item);

    OrderItem toOrderItem(CartItem cartItem);
}
