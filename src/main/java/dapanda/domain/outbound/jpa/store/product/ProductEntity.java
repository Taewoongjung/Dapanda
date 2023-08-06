package dapanda.domain.outbound.jpa.store.product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import dapanda.domain.outbound.jpa.BaseEntity;
import dapanda.domain.outbound.jpa.order.DeliveryOrderEntity;
import dapanda.domain.outbound.jpa.store.StoreEntity;
import dapanda.domain.outbound.jpa.store.product.cloth.ClothEntity;
import dapanda.domain.outbound.jpa.store.product.food.FoodEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

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

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    private StoreEntity store;

    @JsonManagedReference
    @OneToOne(mappedBy = "product", fetch = FetchType.LAZY, orphanRemoval = true)
    private FoodEntity food;

    @JsonManagedReference
    @OneToOne(mappedBy = "product", fetch = FetchType.LAZY, orphanRemoval = true)
    private ClothEntity cloth;

    @JsonManagedReference
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    private List<DeliveryOrderEntity> deliveryOrders;

    private ProductEntity(
            final long id,
            final FoodEntity food,
            final ClothEntity cloth
    ) {
        super(LocalDateTime.now(), LocalDateTime.now());

        this.id = id;
        this.food = food;
        this.cloth = cloth;
    }

    public static ProductEntity of(
            final long id,
            final FoodEntity food,
            final ClothEntity cloth
    ) {
        return new ProductEntity(id, food, cloth);
    }
}
