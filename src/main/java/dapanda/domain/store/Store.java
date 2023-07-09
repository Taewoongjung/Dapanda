package dapanda.domain.store;

import dapanda.domain.customer.Customer;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

import static dapanda.adapter.common.ErrorType.*;
import static dapanda.adapter.util.ObjectCheck.require;

@Getter
@ToString
@RequiredArgsConstructor
public class Store {

    private long id;
    private String storeName;
    private String category;
    private Customer ceoId;
    private LocalDateTime createdAt;
    private LocalDateTime lastModified;

    private Store(
            final long id,
            final String storeName,
            final String category,
            final Customer ceoId,
            final LocalDateTime createdAt,
            final LocalDateTime lastModified
    ) {
        this.id = id;
        this.storeName = storeName;
        this.category = category;
        this.ceoId = ceoId;
        this.createdAt = createdAt;
        this.lastModified = lastModified;
    }

    public static Store of(
            final long id,
            final String storeName,
            final String category,
            final Customer ceoId,
            final LocalDateTime createdAt,
            final LocalDateTime lastModified
    ) {
        require(o -> storeName == null, storeName, INVALID_STORE_NAME);
        require(o -> category == null, category, INVALID_STORE_CATEGORY);
        require(o -> ceoId == null, ceoId, INVALID_STORE_CEO_ID);

        return new Store(id, storeName, category, ceoId, createdAt, lastModified);
    }
}
