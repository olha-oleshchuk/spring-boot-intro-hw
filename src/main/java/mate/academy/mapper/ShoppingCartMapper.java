package mate.academy.mapper;

import mate.academy.config.MapperConfig;
import mate.academy.dao.shoppingCart.CartItemResponseDto;
import mate.academy.dao.shoppingCart.ShoppingCartResponseDto;
import mate.academy.model.CartItem;
import mate.academy.model.ShoppingCart;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface ShoppingCartMapper {
    ShoppingCartResponseDto toDto(ShoppingCart shoppingCart);

    CartItemResponseDto toEntity(CartItem cartItem);
}
