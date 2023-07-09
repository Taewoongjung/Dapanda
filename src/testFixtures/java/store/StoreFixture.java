package store;

import dapanda.domain.store.Store;

import java.time.LocalDateTime;

import static customer.CustomerFixture.CUSTOMER;

public class StoreFixture {

    public static Store STORE = Store.of(
            1L,
            "맛나김밥",
            "음식점",
            CUSTOMER,
            LocalDateTime.now(),
            LocalDateTime.now()
    );
}
