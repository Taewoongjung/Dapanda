package dapanda.adapter.outbound.jpa.store;

import dapanda.adapter.outbound.jpa.BaseEntity;
import dapanda.adapter.outbound.jpa.customer.CustomerEntity;
import dapanda.adapter.outbound.jpa.order.OrderEntity;
import dapanda.adapter.outbound.jpa.store.product.ProductEntity;
import dapanda.domain.store.StoreCategoryType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "store")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StoreEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CustomerEntity> customers = new ArrayList<>();

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductEntity> products = new ArrayList<>();

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderEntity> order = new ArrayList<>();

    private String storeName;

    @Enumerated(value = EnumType.STRING)
    private StoreCategoryType category;

    private StoreEntity(
            final long id,
            final String storeName,
            final StoreCategoryType category
    ) {
        super(LocalDateTime.now(), LocalDateTime.now());

        this.id = id;
        this.storeName = storeName;
        this.category = category;
    }

    public static StoreEntity of(
            final long id,
            final String storeName,
            final StoreCategoryType category
    ) {
        return new StoreEntity(id, storeName, category);
    }
}
