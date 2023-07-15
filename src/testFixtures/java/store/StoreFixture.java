package store;

import dapanda.domain.store.Store;

import java.time.LocalDateTime;

import static dapanda.domain.store.StoreCategoryType.FOOD;

public class StoreFixture {

    public static Store STORE = Store.of(
            1L,
            "맛나김밥",
            FOOD,
            LocalDateTime.now(),
            LocalDateTime.now()
    );
}
