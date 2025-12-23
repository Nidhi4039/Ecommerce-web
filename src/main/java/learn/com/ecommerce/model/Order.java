package learn.com.ecommerce.model;

import jakarta.persistence.*;
import learn.com.ecommerce.enums.OrderStatus;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private Long productId;
    private int quantity;
    private Money totalPrice;

    private OrderStatus status;

    public Order(){}
    public Order(Long productId, int quantity, Money totalPrice) {
        this.productId = productId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.status = OrderStatus.CREATED;
    }

    public void markAsPaid() {
        this.status = OrderStatus.PAID;
    }
}
