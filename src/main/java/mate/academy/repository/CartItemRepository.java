package mate.academy.repository;

import java.util.Optional;
import mate.academy.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    CartItem findCartItemByUserIdAndBookId(Long userId, Long bookId);

    CartItem findByCartItemId(Long cartItemId);

    void deleteByCartItemId(Long cartItemId);

    Optional<CartItem> findByIdAndShoppingCartId(Long cartItemId, Long shoppingCartId);
}
