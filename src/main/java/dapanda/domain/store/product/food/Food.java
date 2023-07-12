package dapanda.domain.store.product.food;

import dapanda.domain.store.Store;
import dapanda.domain.store.product.Product;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

import static dapanda.adapter.common.ErrorType.*;
import static dapanda.adapter.util.Check.require;

@Getter
@RequiredArgsConstructor
public class Food extends Product {

    private int price;
    private boolean isUse;
    private String description;

    private Food(
            final long id,
            final String name,
            final String brandName,
            final int amount,
            final Store store,
            final int price,
            final boolean isUse,
            final String description,
            final LocalDateTime createdAt,
            final LocalDateTime lastModified
    ) {
        super(id, name, brandName, amount, store, createdAt, lastModified);

        this.price = price;
        this.isUse = isUse;
        this.description = description;
    }

    public static Food of(
            final long id,
            final String name,
            final String brandName,
            final Integer amount,
            final Store store,
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
                store,
                price,
                isUse,
                description,
                createdAt,
                lastModified
        );
    }
}
