package dapanda.adapter.outbound.jpa.store.product;

import dapanda.adapter.outbound.jpa.BaseEntity;
import dapanda.adapter.outbound.jpa.store.StoreEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class ProductEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String brandName;

    private int amount;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    private StoreEntity store;

    protected ProductEntity(
            final long id,
            final String name,
            final String brandName,
            final int amount
    ) {
        super(LocalDateTime.now(), LocalDateTime.now());

        this.id = id;
        this.name = name;
        this.brandName = brandName;
        this.amount = amount;
    }
}
