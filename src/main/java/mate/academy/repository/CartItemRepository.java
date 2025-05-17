package mate.academy.repository;

import mate.academy.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    @Query("FROM CartItem c WHERE c.shoppingCart.user.id = :userId AND c.book.id = :bookId")
    CartItem findCartItemByUserIdAndBookId(@Param("userId") Long userId,
                                           @Param("bookId") Long bookId);

    CartItem findByCartItemId(Long cartItemId);

    void deleteByCartItemId(Long cartItemId);
}
