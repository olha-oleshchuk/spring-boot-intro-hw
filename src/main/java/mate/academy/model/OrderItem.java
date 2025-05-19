package mate.academy.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@SQLDelete(sql = "UPDATE order_items SET is_deleted = true WHERE id=?")
@SQLRestriction("is_deleted = false")
@Table(name = "order_items")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    Long orderID;

    @Column(nullable = false)
    Long bookID;

    @Column(nullable = false)
    int quantity;

    @Column(nullable = false)
    BigDecimal price;

    @Column(nullable = false)
    private boolean isDeleted = false;
}
