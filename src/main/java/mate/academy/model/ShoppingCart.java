package mate.academy.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@SQLDelete(sql = "UPDATE shoppingCarts SET is_deleted = true WHERE id=?")
@SQLRestriction("is_deleted = false")
@Table(name = "shoppingCarts")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    private boolean isDeleted = false;

    @ManyToMany
    @JoinTable(name = "shoppingCarts_ cartItems",
            joinColumns = @JoinColumn(name = "shoppingCarts_id"),
            inverseJoinColumns = @JoinColumn(name = "cartItems_id"))
    private Set<CartItem> cartItem = new HashSet<>();
}
