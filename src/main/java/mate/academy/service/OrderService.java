package mate.academy.service;

import java.util.List;
import mate.academy.dao.order.OrderItemResponseDto;
import mate.academy.dao.order.OrderRequestDto;
import mate.academy.dao.order.OrderResponseDto;
import mate.academy.dao.order.OrderUpdateDto;
import org.springframework.data.domain.Pageable;

public interface OrderService {
    List<OrderResponseDto> getAllOrders(Long userId, Pageable pageable);

    OrderResponseDto createOrder(Long userId, OrderRequestDto orderRequestDto);

    List<OrderItemResponseDto> getItemsByOrderId(Long userId, Long orderId);

    OrderItemResponseDto getItemByOrderIdAndItemId(Long userId, Long orderId, Long itemId);

    OrderResponseDto updateOrderStatus(Long id, OrderUpdateDto updateDto);
}
