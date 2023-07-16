package dapanda.adapter.outbound.jpa.order;

import dapanda.adapter.outbound.jpa.BaseEntity;
import dapanda.adapter.outbound.jpa.customer.CustomerEntity;
import dapanda.adapter.outbound.jpa.store.StoreEntity;
import dapanda.adapter.outbound.jpa.store.product.ProductEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "order")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
//    @JoinColumn(name = "store_id", referencedColumnName = "id")
    private StoreEntity store;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
//    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private ProductEntity product;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
//    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private CustomerEntity customer;

    private int amount;

    private OrderEntity(
            final long id,
            final StoreEntity store,
            final ProductEntity product,
            final CustomerEntity customer
    ) {
        this.id = id;
        this.store = store;
        this.product = product;
        this.customer = customer;
    }

    public static OrderEntity of(
            final long id,
            final StoreEntity store,
            final ProductEntity product,
            final CustomerEntity customer
    ) {
        return new OrderEntity(id, store, product, customer);
    }
}