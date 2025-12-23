package learn.com.ecommerce.service;

import jakarta.transaction.Transactional;
import learn.com.ecommerce.model.Inventory;
import learn.com.ecommerce.model.Money;
import learn.com.ecommerce.model.Order;
import learn.com.ecommerce.model.Product;
import learn.com.ecommerce.repository.InventoryRepository;
import learn.com.ecommerce.repository.OrderRepository;
import learn.com.ecommerce.repository.ProductRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final InventoryService inventoryService;
    private final InventoryRepository inventoryRepository;
    private  final ProductRepository productRepository;

    public OrderService(OrderRepository orderRepository, InventoryService inventoryService, InventoryRepository inventoryRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.inventoryService = inventoryService;
        this.inventoryRepository = inventoryRepository;
        this.productRepository = productRepository;
    }

    @Transactional
    public Order placeOrder(Long productId, int quantity, Money price) {
        inventoryService.purches(productId, quantity);
        Double totalAmount = price.getAmount() * quantity;
        Order order = new Order(productId, quantity, new Money(totalAmount, price.getCurrency()));
        return orderRepository.save(order);

    }
}
