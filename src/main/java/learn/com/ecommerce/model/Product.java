package learn.com.ecommerce.model;

import jakarta.persistence.*;
import learn.com.ecommerce.enums.ProductStatus;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Long productId;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false, length = 3)
    private Money price;
    @Column(nullable = false)
    private ProductStatus status;

    public Product(Long productId, Money price, String name) {
        this.name = name;
        this.productId = productId;
        this.price = price;
        this.status = ProductStatus.AVAILABLE;
    }
    public void markOutOfStock() {
        this.status = ProductStatus.OUT_OF_STOCK;
    }
    public void discontinue() {
        this.status = ProductStatus.DISCONTINUED;
    }

    public void markAvailable() {
        this.status = ProductStatus.AVAILABLE;
    }
}
