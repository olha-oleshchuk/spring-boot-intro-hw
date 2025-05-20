package mate.academy.repository;

import java.util.Optional;
import mate.academy.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    CartItem findCartItemByUserIdAndBookId(@Param("userId") Long userId,
                                           @Param("bookId") Long bookId);

    CartItem findByCartItemId(Long cartItemId);

    void deleteByCartItemId(Long cartItemId);

    Optional<CartItem> findByIdAndShoppingCartId(Long cartItemId, Long shoppingCartId);
}
