package dapanda.domain.order;

import dapanda.domain.customer.Customer;
import dapanda.domain.store.Store;
import dapanda.domain.store.product.Product;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Order {

    private final long id;
    private final Store store;
    private final Product product;
    private final Customer customer;
    private final int amount;
    private final LocalDateTime createdAt;
    private final LocalDateTime lastModified;

    private Order(
            final long id,
            final Store store,
            final Product product,
            final Customer customer,
            final int amount,
            final LocalDateTime createdAt,
            final LocalDateTime lastModified
    ) {
        this.id = id;
        this.store = store;
        this.product = product;
        this.customer = customer;
        this.amount = amount;
        this.createdAt = createdAt;
        this.lastModified = lastModified;
    }

    public static Order of(
            final long id,
            final Store storeId,
            final Product productId,
            final Customer customerId,
            final int amount,
            final LocalDateTime createdAt,
            final LocalDateTime lastModified
    ) {
        return new Order(id, storeId, productId, customerId, amount, createdAt, lastModified);
    }
}