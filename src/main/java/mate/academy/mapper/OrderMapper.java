package mate.academy.mapper;

import mate.academy.config.MapperConfig;
import mate.academy.dao.order.OrderItemResponseDto;
import mate.academy.dao.order.OrderRequestDto;
import mate.academy.dao.order.OrderResponseDto;
import mate.academy.model.Order;
import mate.academy.model.OrderItem;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface OrderMapper {
    OrderResponseDto toDto(Order order);

    OrderItemResponseDto toDto(OrderItem item);

    Order toEntity(OrderRequestDto orderRequestDto);
}
