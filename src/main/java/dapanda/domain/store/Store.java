package dapanda.domain.store;

import dapanda.domain.customer.Customer;
import dapanda.domain.order.Order;
import dapanda.domain.store.product.Product;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static dapanda.adapter.common.ErrorType.*;
import static dapanda.adapter.util.Check.require;

@Getter
@RequiredArgsConstructor
public class Store {

    private long id;
    private String storeName;
    private StoreCategoryType category;
    private List<Customer> customers = new ArrayList<>();;
    private List<Product> products = new ArrayList<>();;
    private List<Order> orders = new ArrayList<>();
    private LocalDateTime createdAt;
    private LocalDateTime lastModified;

    private Store(
            final long id,
            final String storeName,
            final StoreCategoryType category,
            final LocalDateTime createdAt,
            final LocalDateTime lastModified
    ) {
        this.id = id;
        this.storeName = storeName;
        this.category = category;
        this.createdAt = createdAt;
        this.lastModified = lastModified;
    }

    public static Store of(
            final long id,
            final String storeName,
            final StoreCategoryType category,
            final LocalDateTime createdAt,
            final LocalDateTime lastModified
    ) {
        require(o -> storeName == null, storeName, INVALID_STORE_NAME);
        require(o -> category == null, category, INVALID_STORE_CATEGORY);

        return new Store(id, storeName, category, createdAt, lastModified);
    }


    public Order getOrderById(final long orderId) {

        return orders.stream()
                .filter(o -> o.getId() == orderId)
                .findFirst()
                .orElseThrow(() -> new NullPointerException("없음"));
    }

    public void setOrders(final List<Order> orderList) {
        this.orders = orderList;
    }

    public void setCustomers(final List<Customer> customerList) {
        this.customers = customerList;
    }

    public void setProducts(final List<Product> productList) {
        this.products = productList;
    }
}
