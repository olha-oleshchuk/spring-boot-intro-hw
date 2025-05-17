package mate.academy.repository;

import mate.academy.model.CartItem;
import mate.academy.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    ShoppingCart findByUserId(Long userId);

    CartItem findCartItemByUserIdAndBookId(Long userId, Long bookId);

    CartItem findByCartItemId(Long cartItemId);

    void deleteByCartItemId(Long cartItemId);
}
