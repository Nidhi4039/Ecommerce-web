/*
package learn.com.ecommerce.service;

import jakarta.transaction.Transactional;
import learn.com.ecommerce.model.Inventory;
import learn.com.ecommerce.model.Product;
import learn.com.ecommerce.repository.InventoryRepository;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {
    private final InventoryRepository inventoryRepository;
    public InventoryService() {
        this.inventoryRepository = null;
    }
    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Transactional
    public void purches(Long  productId, int quantity) throws IllegalArgumentException {
        Inventory inventory = inventoryRepository.findByProductId(productId)
                .orElseThrow(() -> new IllegalArgumentException("Inventory not found for product ID: " + productId));

        if(inventory.isAvailable((quantity)))
        {
            inventory.reduceStock(quantity);
        }
        else {
            throw new IllegalArgumentException("Insufficient stock for product Requested: " + quantity + ", Available: " + inventory.getQuantity());
        }
    }
}
*/
