package learn.com.ecommerce.model;

import jakarta.persistence.*;

@Entity
@Table(name = "inventory" , uniqueConstraints = @UniqueConstraint(columnNames = {"product_id"}))
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "product_id", nullable = false)
    private final Long productId;

    @Column(nullable = false)
    private int quantity;

    @Version
    private Long version;
    public Inventory(Long productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }
    public  int getQuantity() {
        return quantity;
    }

    public boolean isAvailable(int requestedQuantity) {
        return quantity >= requestedQuantity;
    }
    public void addStock(int amount) {
        this.quantity += amount;
    }
    public void reduceStock(int amount) {
        if (amount <= this.quantity) {
            this.quantity -= amount;
        } else {
            throw new IllegalArgumentException("Insufficient stock to remove the requested amount.");
        }
    }
}
