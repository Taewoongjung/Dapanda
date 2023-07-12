package dapanda.adapter.outbound.jpa.store.product.cloth;

import dapanda.adapter.outbound.jpa.store.product.ProductEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@Entity
@Table(name = "cloth")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ClothEntity extends ProductEntity {

    private int price;
    private boolean isUse;
    private String description;

    private ClothEntity (
            final long id,
            final String name,
            final String brandName,
            final int amount,
            final int price,
            final boolean isUse,
            final String description
    ) {
        super(id, name, brandName, amount);

        this.price = price;
        this.isUse = isUse;
        this.description = description;
    }

    public static ClothEntity of(
            final long id,
            final String name,
            final String brandName,
            final int amount,
            final int price,
            final boolean isUse,
            final String description
    ) {
        return new ClothEntity(id, name, brandName, amount, price, isUse, description);
    }
}
