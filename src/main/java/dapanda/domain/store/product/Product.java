package dapanda.domain.store.product;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

import static dapanda.adapter.common.ErrorType.INVALID_PRODUCT_NAME;
import static dapanda.adapter.util.ObjectCheck.require;

@Getter
@ToString
@RequiredArgsConstructor
public class Product {
    private long id;
    private String name;
    private String brandName;
    private long price;
    private boolean isUse;
    private LocalDateTime createdAt;
    private LocalDateTime lastModified;

    private Product(
            final long id,
            final String name,
            final String brandName,
            final long price,
            final boolean isUse,
            final LocalDateTime createdAt,
            final LocalDateTime lastModified
    ) {
        this.id = id;
        this.name = name;
        this.brandName = brandName;
        this.price = price;
        this.isUse = isUse;
        this.createdAt = createdAt;
        this.lastModified = lastModified;
    }

    public static Product of(
            final long id,
            final String name,
            final String brandName,
            final long price,
            final boolean isUse,
            final LocalDateTime createdAt,
            final LocalDateTime lastModified
    ) {
        require(o -> name == null, name, INVALID_PRODUCT_NAME);

        return new Product(id, name, brandName, price, isUse, createdAt, lastModified);
    }
}
