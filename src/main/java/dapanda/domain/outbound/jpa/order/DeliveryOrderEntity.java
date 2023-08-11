package dapanda.domain.outbound.jpa.order;

import com.fasterxml.jackson.annotation.JsonBackReference;
import dapanda.domain.outbound.jpa.BaseEntity;
import dapanda.domain.outbound.jpa.customer.CustomerEntity;
import dapanda.domain.outbound.jpa.store.StoreEntity;
import dapanda.domain.outbound.jpa.store.product.ProductEntity;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
//@Entity
//@Table(name = "delivery_order")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DeliveryOrderEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "store_id", referencedColumnName = "id")
    private StoreEntity store;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private ProductEntity product;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private CustomerEntity customer;

    private int amount;

    private DeliveryOrderEntity(
            final long id,
            final StoreEntity store,
            final ProductEntity product,
            final CustomerEntity customer,
            final int amount
    ) {
        super(LocalDateTime.now(), LocalDateTime.now());

        this.id = id;
        this.store = store;
        this.product = product;
        this.customer = customer;
        this.amount = amount;
    }

    public static DeliveryOrderEntity of(
            final long id,
            final StoreEntity store,
            final ProductEntity product,
            final CustomerEntity customer,
            final int amount
    ) {
        return new DeliveryOrderEntity(id, store, product, customer, amount);
    }
}
