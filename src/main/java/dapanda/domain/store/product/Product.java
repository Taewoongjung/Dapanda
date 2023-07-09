package dapanda.domain.store.product;

import dapanda.domain.store.Store;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
@RequiredArgsConstructor
public abstract class Product {
    private long id;
    private String name;
    private String brandName;
    private int amount;
    private Store store;
    private LocalDateTime createdAt;
    private LocalDateTime lastModified;

    public Product(
            final long id,
            final String name,
            final String brandName,
            final int amount,
            final Store store,
            final LocalDateTime createdAt,
            final LocalDateTime lastModified
    ) {
        this.id = id;
        this.name = name;
        this.brandName = brandName;
        this.amount = amount;
        this.store = store;
        this.createdAt = createdAt;
        this.lastModified = lastModified;
    }
}
