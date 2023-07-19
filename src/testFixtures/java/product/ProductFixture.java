package product;

import dapanda.domain.store.product.Product;
import dapanda.domain.store.product.cloth.Cloth;
import dapanda.domain.store.product.food.Food;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static cloth.ClothFixture.CLOTH_NEW;
import static food.FoodFixture.FOOD;
import static store.StoreFixture.STORE;

public class ProductFixture {

    public static Product PRODUCT() {

        List<Food> foods = new ArrayList<>();
        foods.add(FOOD);
        foods.add(FOOD);
        foods.add(FOOD);

        List<Cloth> cloths = new ArrayList<>();
        cloths.add(CLOTH_NEW);
        cloths.add(CLOTH_NEW);

        return Product.of(
        1L,
            STORE,
            foods,
            cloths,
            LocalDateTime.now(),
            LocalDateTime.now()
        );
    }
}
