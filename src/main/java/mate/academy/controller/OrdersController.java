package mate.academy.controller;

import java.util.List;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import mate.academy.dao.order.OrderRequestDto;
import mate.academy.dao.order.OrderResponseDto;
import mate.academy.dao.order.OrderUpdateDto;
import mate.academy.dao.shoppingcart.CartItemResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Orders management", description = "Endpoints for managing orders")
@RequiredArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrdersController {
    @GetMapping
    public List<OrderResponseDto> getAllOrders() {
    }

    @PostMapping
    public OrderResponseDto createOrder(@RequestBody OrderRequestDto requestDto) {
    }

    @GetMapping("/{orderId}/items")
    public List<CartItemResponseDto> getItemsByOrderId(@PathVariable Long orderId) {
    }

    @GetMapping("/{orderId}/items/{itemId}")
    public CartItemResponseDto getItemByOrderIdAndItemId(
            @PathVariable Long orderId,
            @PathVariable Long itemId) {
    }

    @PatchMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public OrderResponseDto updateOrderStatus(
            @PathVariable Long id,
            @RequestBody OrderUpdateDto updateDto) {
    }
}
