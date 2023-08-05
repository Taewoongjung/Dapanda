package dapanda.domain.outbound.jpa.order;

import dapanda.domain.outbound.jpa.BaseEntity;
import dapanda.domain.outbound.jpa.customer.CustomerEntity;
import dapanda.domain.outbound.jpa.store.StoreEntity;
import dapanda.domain.outbound.jpa.store.product.ProductEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "delivery_order")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DeliveryOrderEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "store_id", referencedColumnName = "id", nullable = false)
    private StoreEntity store;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
    private ProductEntity product;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
    private CustomerEntity customer;

    private int amount;

    private DeliveryOrderEntity(
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

    public static DeliveryOrderEntity of(
            final long id,
            final StoreEntity store,
            final ProductEntity product,
            final CustomerEntity customer
    ) {
        return new DeliveryOrderEntity(id, store, product, customer);
    }
}
