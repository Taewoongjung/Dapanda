package food;

import dapanda.domain.store.product.food.Food;

import java.time.LocalDateTime;

import static store.StoreFixture.STORE;

public class FoodFixture {

    public static Food FOOD = Food.of(
            1, "순대", "맛나분식",
            100, STORE, 1500, true,
            "정말맛있어요", LocalDateTime.now(), LocalDateTime.now()
    );
}
