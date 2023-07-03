package GupangMSA.inventory.mock;

import GupangMSA.inventory.domain.Inventory;
import GupangMSA.inventory.service.port.InventoryRepository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FakeInventoryRepository implements InventoryRepository {

    private final Map<Long, Integer> data = new ConcurrentHashMap<>();

    @Override
    public Integer save(Inventory request) {
        // key가 없으면 저장, 있면 수정후 저장
        data.put(request.getProductId(), request.getLeft());
        return data.get(request.getProductId());
    }

    @Override
    public Integer findByProductId(Long productId) {
        return data.get(productId);
    }

}
