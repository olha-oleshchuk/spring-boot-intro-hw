package mate.academy.model;

import ch.qos.logback.core.status.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@SQLDelete(sql = "UPDATE orders SET is_deleted = true WHERE id=?")
@SQLRestriction("is_deleted = false")
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    Long userId;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(nullable = false)
    BigDecimal total;

    @Column(nullable = false)
    LocalDateTime orderDate;

    @Column(nullable = false)
    String shippingAddress;

    Set<OrderItem> orderItems;

    @Column(nullable = false)
    private boolean isDeleted = false;

    public enum Status {
        COMPLETED,
        PENDING,
        DELIVERED
    }
}
