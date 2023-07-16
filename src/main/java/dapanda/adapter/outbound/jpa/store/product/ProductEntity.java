package dapanda.adapter.outbound.jpa.store.product;

import dapanda.adapter.outbound.jpa.BaseEntity;
import dapanda.adapter.outbound.jpa.store.StoreEntity;
import dapanda.adapter.outbound.jpa.store.product.cloth.ClothEntity;
import dapanda.adapter.outbound.jpa.store.product.food.FoodEntity;
import dapanda.domain.store.product.cloth.Cloth;
import dapanda.domain.store.product.food.Food;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

import static dapanda.adapter.util.ObjectConverter.toClothEntity;
import static dapanda.adapter.util.ObjectConverter.toFoodEntity;

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

    public void setFoodsEntityList(final List<Food> pojo) {

        if (pojo == null) return;  // 에러 던지기

        pojo.forEach(pojoDomain -> {
            foods.add(
                    toFoodEntity(Food.of(
                            pojoDomain.getId(),
                            pojoDomain.getName(),
                            pojoDomain.getBrandName(),
                            pojoDomain.getAmount(),
                            pojoDomain.getPrice(),
                            pojoDomain.isUse(),
                            pojoDomain.getDescription(),
                            pojoDomain.getCreatedAt(),
                            pojoDomain.getLastModified()
                    ))
            );
        });
    }

    public void setClothsEntityList(final List<Cloth> pojo) {

        if (pojo == null) return;  // 에러 던지기

        pojo.forEach(pojoDomain -> {
            cloths.add(
                    toClothEntity(Cloth.of(
                            pojoDomain.getId(),
                            pojoDomain.getName(),
                            pojoDomain.getBrandName(),
                            pojoDomain.getAmount(),
                            pojoDomain.getPrice(),
                            pojoDomain.isUse(),
                            pojoDomain.getDescription(),
                            pojoDomain.getCreatedAt(),
                            pojoDomain.getLastModified()
                    ))
            );
        });
    }
}
