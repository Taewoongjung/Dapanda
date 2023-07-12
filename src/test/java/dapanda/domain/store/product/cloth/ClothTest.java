package dapanda.domain.store.product.cloth;

import dapanda.adapter.common.InvalidInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static cloth.ClothFixture.CLOTH_NEW;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Cloth를")
class ClothTest {

    @Test
    @DisplayName("생성할 수 있다.")
    void test1() {

        assertDoesNotThrow(() -> Cloth.of(
                CLOTH_NEW.getId(),
                CLOTH_NEW.getName(),
                CLOTH_NEW.getBrandName(),
                CLOTH_NEW.getAmount(),
                CLOTH_NEW.getStore(),
                CLOTH_NEW.getPrice(),
                CLOTH_NEW.isUse(),
                CLOTH_NEW.getDescription(),
                CLOTH_NEW.getCreatedAt(),
                CLOTH_NEW.getLastModified()
        ));
    }

    @Test
    @DisplayName("필수값 옷이름이 없으면 생성할 수 없다.")
    void test2() {
        assertThatThrownBy(() -> Cloth.of(
                CLOTH_NEW.getId(),
                null,
                CLOTH_NEW.getBrandName(),
                CLOTH_NEW.getAmount(),
                CLOTH_NEW.getStore(),
                CLOTH_NEW.getPrice(),
                CLOTH_NEW.isUse(),
                CLOTH_NEW.getDescription(),
                CLOTH_NEW.getCreatedAt(),
                CLOTH_NEW.getLastModified()
        ))
                .isInstanceOf(InvalidInputException.class)
                .hasMessage("상품 이름은 필수값 입니다.");
    }

    @Test
    @DisplayName("필수값 개수가 없으면 생성할 수 없다.")
    void test3() {
        assertThatThrownBy(() -> Cloth.of(
                CLOTH_NEW.getId(),
                CLOTH_NEW.getName(),
                CLOTH_NEW.getBrandName(),
                null,
                CLOTH_NEW.getStore(),
                CLOTH_NEW.getPrice(),
                CLOTH_NEW.isUse(),
                CLOTH_NEW.getDescription(),
                CLOTH_NEW.getCreatedAt(),
                CLOTH_NEW.getLastModified()
        ))
                .isInstanceOf(InvalidInputException.class)
                .hasMessage("상품 수량은 필수값 입니다.");
    }

    @Test
    @DisplayName("필수값 가격이 없으면 생성할 수 없다.")
    void test4() {
        assertThatThrownBy(() -> Cloth.of(
                CLOTH_NEW.getId(),
                CLOTH_NEW.getName(),
                CLOTH_NEW.getBrandName(),
                CLOTH_NEW.getAmount(),
                CLOTH_NEW.getStore(),
                null,
                CLOTH_NEW.isUse(),
                CLOTH_NEW.getDescription(),
                CLOTH_NEW.getCreatedAt(),
                CLOTH_NEW.getLastModified()
        ))
                .isInstanceOf(InvalidInputException.class)
                .hasMessage("상품 가격은 필수값 입니다.");
    }
}