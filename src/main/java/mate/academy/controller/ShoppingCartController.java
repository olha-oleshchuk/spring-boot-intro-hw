package mate.academy.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mate.academy.dao.shoppingcart.AddCartItemRequestDto;
import mate.academy.dao.shoppingcart.ShoppingCartResponseDto;
import mate.academy.dao.shoppingcart.UpdateCartItemRequestDto;
import mate.academy.model.ShoppingCart;
import mate.academy.model.User;
import mate.academy.repository.ShoppingCartRepository;
import mate.academy.service.ShoppingCartService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Shopping cart management", description = "Endpoints for managing shopping cart")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/cart")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;
    private final ShoppingCartRepository shoppingCartRepository;

    @PreAuthorize("hasRole('ROLE_USER')")
    @Operation(summary = "Get shopping cart for current user",
            description = "Get specific shopping cart")
    @GetMapping
    public ShoppingCartResponseDto getShoppingCartForCurrentUser(
            @AuthenticationPrincipal User user) {
        return shoppingCartService.getShoppingCartForCurrentUser(user.getId());
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @Operation(summary = "Add item to cart",
            description = "Add specific item to user's shopping cart")
    @PostMapping
    public ShoppingCartResponseDto addItemToCart(
            @RequestBody @Valid AddCartItemRequestDto requestDto,
            @AuthenticationPrincipal User user) {
        return shoppingCartService.addItemToCart(user.getId(),
                requestDto.getBookId(), requestDto.getQuantity());
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @Operation(summary = "Update item in cart",
            description = "Update quantity of specific item")
    @PutMapping("/items/{cartItemId}")
    public ShoppingCartResponseDto updateCartItem(
            @PathVariable Long cartItemId,
            @RequestBody @Valid UpdateCartItemRequestDto requestDto,
            @AuthenticationPrincipal User user) {
        ShoppingCart cart = shoppingCartRepository.getEntityByUserId(user.getId());
        return shoppingCartService.updateCartItemQuantity(cart.getId(),
                cartItemId, requestDto.getQuantity());
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @Operation(summary = "Delete item from cart",
            description = "Delete specific item from shopping cart")
    @DeleteMapping("/items/{cartItemId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long cartItemId,
                       @AuthenticationPrincipal User user) {
        ShoppingCart cart = shoppingCartRepository.getEntityByUserId(user.getId());
        shoppingCartService.deleteCartItem(cart.getId(), cartItemId);
    }
}
