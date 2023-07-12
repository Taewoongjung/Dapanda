package dapanda.application.store;

import dapanda.domain.store.StoreCategoryType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static dapanda.domain.store.StoreCategoryType.FOOD;

class StoreServiceTest {

    @Test
    @DisplayName("음식을 주문할 수 있다.")
    void test1() {

        // given
            // path variable
        final long storeId = 1L;
        final long productId = 10L;

            // web request
        final int orderAmount = 2;
        final String categoryType = FOOD.getTypeName();

        // when


        // then
    }

    @Test
    @DisplayName("옷을 주문할 수 있다.")
    void test2() {

        // given

        // when

        // then
    }
}