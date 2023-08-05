package dapanda.domain.outbound.jpa.store.product.food;

import dapanda.domain.outbound.jpa.BaseEntity;
import dapanda.domain.outbound.jpa.store.product.ProductEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "food")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FoodEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String brandName;

    private int amount;

    private int price;

    private boolean isUse;

    private String description;

    @OneToOne(mappedBy = "food")
    private ProductEntity product;

    private FoodEntity(
            final long id,
            final String name,
            final String brandName,
            final int amount,
            final int price,
            final boolean isUse,
            final String description
    ) {
        super(LocalDateTime.now(), LocalDateTime.now());

        this.id = id;
        this.name = name;
        this.brandName = brandName;
        this.amount = amount;
        this.price = price;
        this.isUse = isUse;
        this.description = description;
    }

    public static FoodEntity of(
            final long id,
            final String name,
            final String brandName,
            final int amount,
            final int price,
            final boolean isUse,
            final String description
    ) {
        return new FoodEntity(id, name, brandName, amount, price, isUse, description);
    }
}
