package GupangMSA.inventory.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Inventory {

    private final Long productId;
    private final int left;

    @Builder
    public Inventory(Long productId, int left) {
        this.productId = productId;
        this.left = left;
    }
}
