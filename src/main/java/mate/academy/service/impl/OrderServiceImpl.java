package mate.academy.service.impl;

import jakarta.transaction.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import mate.academy.dao.order.OrderItemResponseDto;
import mate.academy.dao.order.OrderRequestDto;
import mate.academy.dao.order.OrderResponseDto;
import mate.academy.dao.order.OrderUpdateDto;
import mate.academy.exception.EntityNotFoundException;
import mate.academy.mapper.OrderMapper;
import mate.academy.model.Order;
import mate.academy.model.OrderItem;
import mate.academy.repository.OrderItemRepository;
import mate.academy.repository.OrderRepository;
import mate.academy.service.OrderService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderItemRepository orderItemRepository;
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    // 1. Отримуємо користувача (в залежності від реалізації безпеки)
    // 2. Отримуємо shopping cart
    // 3. Створюємо замовлення
    // 4. Створюємо список OrderItem
    // 5. Підраховуємо total
    // 6. Зберігаємо замовлення
    // 7. Очищаємо кошик
    // 8. Повертаємо DTO

    @Override
    public OrderResponseDto createOrder(OrderRequestDto requestDto) {
        Order order = orderMapper.toEntity(requestDto);
        order.setOrderDate(LocalDateTime.now());
        int price = 0;
        order.setTotal(BigDecimal.ZERO); order.getOrderItems()
                .forEach(item -> {price =+ item.getPrice()});
        order.setStatus(order.getStatus());
        orderRepository.save(order);
        return orderMapper.toDto(order);
    }

    @Override
    public List<OrderResponseDto> getAllOrders(Long userId, Pageable pageable) {
        return orderRepository.findAllByUserId(userId, pageable).stream()
                .map(orderMapper::toDto)
                .toList();
    }

    @Override
    public OrderItemResponseDto getItemByOrderIdAndItemId(Long userId, Long orderId, Long itemId) {
        OrderItem item = orderItemRepository.findByIdAndOrderIdAndUserId(userId, orderId, itemId)
                .orElseThrow(() -> new EntityNotFoundException("Can't find order item by order id "
                        + orderId + ", item id " + itemId + " and user id " + userId));
        return orderMapper.toDto(item);
    }

    @Override
    public List<OrderItemResponseDto> getItemsByOrderId(Long userId, Long orderId) {
        return orderItemRepository.findByOrderIdAndUserId(userId, orderId).stream()
                .map(orderMapper::toDto)
                .toList();
    }

    @Override
    public OrderResponseDto updateOrderStatus(Long orderId, OrderUpdateDto updateDto) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() ->
                        new EntityNotFoundException("Can't find order by id " + orderId));
        order.setStatus(updateDto.getStatus());
        return orderMapper.toDto(orderRepository.save(order));
    }
}
