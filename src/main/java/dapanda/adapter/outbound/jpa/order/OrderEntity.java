package dapanda.adapter.outbound.jpa.order;

import dapanda.adapter.outbound.jpa.BaseEntity;
import dapanda.adapter.outbound.jpa.customer.CustomerEntity;
import dapanda.adapter.outbound.jpa.store.StoreEntity;
import dapanda.adapter.outbound.jpa.store.product.ProductEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Entity
@ToString(exclude = {"store", "product"})
@Table(name = "`order`")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    private StoreEntity store;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    private ProductEntity product;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    private CustomerEntity customer;

    private Integer amount;

    private OrderEntity(
            final long id,
            final StoreEntity store,
            final ProductEntity product,
            final CustomerEntity customer,
            final Integer amount
    ) {
        super(LocalDateTime.now(), LocalDateTime.now());

        this.id = id;
        this.store = store;
        this.product = product;
        this.customer = customer;
        this.amount = amount;
    }

    public static OrderEntity of(
            final long id,
            final StoreEntity store,
            final ProductEntity product,
            final CustomerEntity customer,
            final Integer amount
    ) {
        return new OrderEntity(id, store, product, customer, amount);
    }
}