package dapanda.adapter.outbound.jpa.store;

import dapanda.adapter.outbound.jpa.BaseEntity;
import dapanda.adapter.outbound.jpa.customer.CustomerEntity;
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

    private String storeName;

    private String category;

    private StoreEntity(
            final long id,
            final String storeName,
            final String category
    ) {
        super(LocalDateTime.now(), LocalDateTime.now());

        this.id = id;
        this.storeName = storeName;
        this.category = category;
    }

    public static StoreEntity of(
            final long id,
            final String storeName,
            final String category
    ) {
        return new StoreEntity(id, storeName, category);
    }
}
