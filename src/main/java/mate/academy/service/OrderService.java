package mate.academy.service;

import java.util.List;

import mate.academy.dao.order.OrderRequestDto;
import mate.academy.dao.order.OrderResponseDto;
import mate.academy.dao.order.OrderUpdateDto;
import mate.academy.dao.shoppingcart.CartItemResponseDto;
import org.springframework.data.domain.Pageable;

public interface OrderService {
    List<OrderResponseDto> getAllOrders(Long userId, Pageable pageable);

    OrderResponseDto createOrder(OrderRequestDto requestDto);

    List<CartItemResponseDto> getItemsByOrderId(Long orderId);

    CartItemResponseDto getItemByOrderIdAndItemId(Long orderId, Long itemId);

    OrderResponseDto updateOrderStatus(Long id, OrderUpdateDto updateDto);
}
