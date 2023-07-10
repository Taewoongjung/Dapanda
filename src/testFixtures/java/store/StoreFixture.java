package store;

import dapanda.domain.store.Store;

import java.time.LocalDateTime;

public class StoreFixture {

    public static Store STORE = Store.of(
            1L,
            "맛나김밥",
            "음식점",
            LocalDateTime.now(),
            LocalDateTime.now()
    );
}
