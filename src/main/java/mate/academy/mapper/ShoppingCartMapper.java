package mate.academy.mapper;

import mate.academy.config.MapperConfig;
import mate.academy.dao.shoppingcart.CartItemResponseDto;
import mate.academy.dao.shoppingcart.ShoppingCartResponseDto;
import mate.academy.model.CartItem;
import mate.academy.model.ShoppingCart;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface ShoppingCartMapper {
    ShoppingCartResponseDto toDto(ShoppingCart shoppingCart);

    CartItemResponseDto toDto(CartItem cartItem);
}
