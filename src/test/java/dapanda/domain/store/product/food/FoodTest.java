//package dapanda.domain.store.product.food;
//
//import dapanda.domain.common.InvalidInputException;
//import dapanda.domain.store.product.cloth.Cloth;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import static food.FoodFixture.FOOD;
//import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
//import static org.junit.jupiter.api.Assertions.*;
//
//@DisplayName("Food를")
//class FoodTest {
//
//    @Test
//    @DisplayName("생성할 수 있다.")
//    void test1() {
//        assertDoesNotThrow(() -> Food.of(
//                FOOD.getId(),
//                FOOD.getName(),
//                FOOD.getBrandName(),
//                FOOD.getAmount(),
//                FOOD.getPrice(),
//                FOOD.isUse(),
//                FOOD.getDescription(),
//                FOOD.getCreatedAt(),
//                FOOD.getLastModified()
//        ));
//    }
//
//    @Test
//    @DisplayName("필수값 옷이름이 없으면 생성할 수 없다.")
//    void test2() {
//        assertThatThrownBy(() -> Cloth.of(
//                FOOD.getId(),
//                null,
//                FOOD.getBrandName(),
//                FOOD.getAmount(),
//                FOOD.getPrice(),
//                FOOD.isUse(),
//                FOOD.getDescription(),
//                FOOD.getCreatedAt(),
//                FOOD.getLastModified()
//        ))
//                .isInstanceOf(InvalidInputException.class)
//                .hasMessage("상품 이름은 필수값 입니다.");
//    }
//
//    @Test
//    @DisplayName("필수값 개수가 없으면 생성할 수 없다.")
//    void test3() {
//        assertThatThrownBy(() -> Cloth.of(
//                FOOD.getId(),
//                FOOD.getName(),
//                FOOD.getBrandName(),
//                null,
//                FOOD.getPrice(),
//                FOOD.isUse(),
//                FOOD.getDescription(),
//                FOOD.getCreatedAt(),
//                FOOD.getLastModified()
//        ))
//                .isInstanceOf(InvalidInputException.class)
//                .hasMessage("상품 수량은 필수값 입니다.");
//    }
//
//    @Test
//    @DisplayName("필수값 가격이 없으면 생성할 수 없다.")
//    void test4() {
//        assertThatThrownBy(() -> Cloth.of(
//                FOOD.getId(),
//                FOOD.getName(),
//                FOOD.getBrandName(),
//                FOOD.getAmount(),
//                null,
//                FOOD.isUse(),
//                FOOD.getDescription(),
//                FOOD.getCreatedAt(),
//                FOOD.getLastModified()
//        ))
//                .isInstanceOf(InvalidInputException.class)
//                .hasMessage("상품 가격은 필수값 입니다.");
//    }
//
//}