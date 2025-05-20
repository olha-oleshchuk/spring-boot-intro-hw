package mate.academy.repository;

import java.util.List;
import mate.academy.dao.shoppingcart.CartItemResponseDto;
import mate.academy.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    OrderItem getByOrderIdAndItemId(Long orderId, Long itemId);

    List<CartItemResponseDto> getAllItemsByOrderId(Long orderId);
}
