package GupangMSA.inventory.service;

import GupangMSA.inventory.domain.Inventory;
import GupangMSA.inventory.service.port.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public Integer create(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    public Integer getByProductId(Long productId) {
        return inventoryRepository.findByProductId(productId);
    }

    public void updateCount(Inventory inventory) {
        inventoryRepository.save(inventory);
    }

}
