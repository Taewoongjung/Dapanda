package dapanda.domain.outbound.jpa.store.product;

import dapanda.domain.outbound.jpa.BaseEntity;
import dapanda.domain.outbound.jpa.store.StoreEntity;
import dapanda.domain.outbound.jpa.store.product.cloth.ClothEntity;
import dapanda.domain.outbound.jpa.store.product.food.FoodEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Entity
@Table(name = "product")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    private StoreEntity store;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<FoodEntity> foods;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<ClothEntity> cloths;

    private ProductEntity(
            final long id,
            final StoreEntity store
    ) {
        super(LocalDateTime.now(), LocalDateTime.now());

        this.id = id;
        this.store = store;
    }

    public static ProductEntity of(
            final long id,
            final StoreEntity store
    ) {
        return new ProductEntity(id, store);
    }
}
