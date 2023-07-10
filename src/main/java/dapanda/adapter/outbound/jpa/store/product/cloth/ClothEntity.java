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
}
