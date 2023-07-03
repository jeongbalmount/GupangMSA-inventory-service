package GupangMSA.inventory.service;

import GupangMSA.inventory.domain.Inventory;
import GupangMSA.inventory.mock.FakeInventoryRepository;
import GupangMSA.inventory.service.port.InventoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

public class InventoryServiceTest {

    private InventoryService inventoryService;

    @BeforeEach
    void init() {

        Inventory inventory = Inventory.builder()
                .productId(1L)
                .left(100)
                .build();
        InventoryRepository inventoryRepository = new FakeInventoryRepository();
        inventoryRepository.save(inventory);
        inventoryService = new InventoryService(inventoryRepository);
    }

    @Test
    void create로_inventory_도메인을_만들_수_있다() {
        // given
        Inventory inventory = Inventory.builder()
                .productId(1L)
                .left(100)
                .build();
        // when
        Integer value = inventoryService.create(inventory);

        // then
        assertThat(value).isEqualTo(100);
    }
    @Test
    void getByProductId로_재고를_알_수_있다() {
        // given

        // when
        Integer productLeft = this.inventoryService.getByProductId(1L);

        // then
        assertThat(productLeft).isEqualTo(100);
    }

    @Test
    void update로_상품재고값을_수정할_수_있다() {
        // given
        Inventory updateInventory = Inventory.builder()
                .productId(1L)
                .left(999)
                .build();

        // when
        this.inventoryService.updateCount(updateInventory);

        // then
        assertThat(this.inventoryService.getByProductId(1L)).isEqualTo(999);
    }

}
