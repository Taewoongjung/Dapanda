package cloth;

import dapanda.domain.store.product.cloth.Cloth;

import java.time.LocalDateTime;

public class ClothFixture {

    public static Cloth CLOTH_NEW = Cloth.of(
            1, "멋진바지", "멋진브랜드",
            12, 70000, true,
            "정말멋져요", LocalDateTime.now(), LocalDateTime.now()
    );
}
