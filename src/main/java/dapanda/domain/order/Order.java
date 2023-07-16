package dapanda.domain.order;

import dapanda.domain.customer.Customer;
import dapanda.domain.store.Store;
import dapanda.domain.store.product.Product;
import lombok.Getter;
import lombok.ToString;

@Getter
public class Order {

    private long id;
    private Store store;
    private Product product;
    private Customer customer;
    private int amount;

    private Order(
            final long id,
            final Store store,
            final Product product,
            final Customer customer,
            final int amount
    ) {
        this.id = id;
        this.store = store;
        this.product = product;
        this.customer = customer;
        this.amount = amount;
    }

    private Order(
            final Store store,
            final Product product,
            final Customer customer,
            final int amount
    ) {
        this.store = store;
        this.product = product;
        this.customer = customer;
        this.amount = amount;
    }

    public static Order of(
            final long id,
            final Store storeId,
            final Product productId,
            final Customer customerId,
            final int amount
    ) {
        return new Order(id, storeId, productId, customerId, amount);
    }

    public static Order of(
            final Store storeId,
            final Product productId,
            final Customer customerId,
            final int amount
    ) {
        return new Order(storeId, productId, customerId, amount);
    }
}