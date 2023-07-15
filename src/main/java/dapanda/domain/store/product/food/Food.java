package dapanda.domain.store.product.food;

import lombok.Getter;

import java.time.LocalDateTime;

import static dapanda.adapter.common.ErrorType.*;
import static dapanda.adapter.util.Check.require;

@Getter
public class Food {

    private final long id;
    private final String name;
    private final String brandName;
    private final int amount;
    private final int price;
    private final boolean isUse;
    private final String description;
    private final LocalDateTime createdAt;
    private final LocalDateTime lastModified;

    private Food(
            final long id,
            final String name,
            final String brandName,
            final int amount,
            final int price,
            final boolean isUse,
            final String description,
            final LocalDateTime createdAt,
            final LocalDateTime lastModified
    ) {
        this.id = id;
        this.name = name;
        this.brandName = brandName;
        this.amount = amount;
        this.price = price;
        this.isUse = isUse;
        this.description = description;
        this.createdAt = createdAt;
        this.lastModified = lastModified;
    }

    public static Food of(
            final long id,
            final String name,
            final String brandName,
            final Integer amount,
            final Integer price,
            final boolean isUse,
            final String description,
            final LocalDateTime createdAt,
            final LocalDateTime lastModified
    ) {
        require(o -> name == null, name, INVALID_PRODUCT_NAME);
        require(o -> amount == null, amount, INVALID_PRODUCT_AMOUNT);
        require(o -> price == null, price, INVALID_PRODUCT_PRICE);

        return new Food(
                id,
                name,
                brandName,
                amount,
                price,
                isUse,
                description,
                createdAt,
                lastModified
        );
    }
}
