package GupangMSA.inventory.service.port;

import GupangMSA.inventory.domain.Inventory;

import java.util.List;

public interface InventoryRepository {

    // save
    Integer save(Inventory request);

    // return
    Integer findByProductId(Long productId);

}
