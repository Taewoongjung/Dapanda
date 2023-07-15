package dapanda.domain.store.product;

import dapanda.domain.store.Store;
import dapanda.domain.store.product.cloth.Cloth;
import dapanda.domain.store.product.food.Food;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class Product {
    private long id;
    private Store store;
    private List<Food> foods;
    private List<Cloth> cloths;
    private LocalDateTime createdAt;
    private LocalDateTime lastModified;

    private Product(
            final long id,
            final Store store,
            final LocalDateTime createdAt,
            final LocalDateTime lastModified
    ) {
        this.id = id;
        this.store = store;
        this.createdAt = createdAt;
        this.lastModified = lastModified;
    }

    public static Product of(
            final long id,
            final Store store,
            final LocalDateTime createdAt,
            final LocalDateTime lastModified
    ) {
        return new Product(id, store, createdAt, lastModified);
    }
}
