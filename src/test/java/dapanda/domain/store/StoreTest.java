package dapanda.domain.store;

import dapanda.adapter.common.InvalidInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static store.StoreFixture.STORE;

@DisplayName("Store를")
class StoreTest {

    @Test
    @DisplayName("생성할 수 있다.")
    void test1() {
        assertDoesNotThrow(() -> STORE.of(
                STORE.getId(),
                STORE.getStoreName(),
                STORE.getCategory(),
                STORE.getCeoId(),
                STORE.getCreatedAt(),
                STORE.getLastModified()
        ));
    }

    @Test
    @DisplayName("필수값 가게이름이 없으면 생성할 수 없다.")
    void test2() {
        assertThatThrownBy(() -> Store.of(
                STORE.getId(),
                null,
                STORE.getCategory(),
                STORE.getCeoId(),
                STORE.getCreatedAt(),
                STORE.getLastModified()
        ))
                .isInstanceOf(InvalidInputException.class)
                .hasMessage("가게이름은 필수값 입니다.");
    }

    @Test
    @DisplayName("필수값 가게 카테고리가 없으면 생성할 수 없다.")
    void test3() {
        assertThatThrownBy(() -> Store.of(
                STORE.getId(),
                STORE.getStoreName(),
                null,
                STORE.getCeoId(),
                STORE.getCreatedAt(),
                STORE.getLastModified()
        ))
                .isInstanceOf(InvalidInputException.class)
                .hasMessage("가게 카테고리는 필수값 입니다.");
    }

    @Test
    @DisplayName("필수값 가게 사장님 ID가 없으면 생성할 수 없다.")
    void test4() {
        assertThatThrownBy(() -> Store.of(
                STORE.getId(),
                STORE.getStoreName(),
                STORE.getCategory(),
                null,
                STORE.getCreatedAt(),
                STORE.getLastModified()
        ))
                .isInstanceOf(InvalidInputException.class)
                .hasMessage("가게 사장님 ID는 필수값 입니다.");
    }

}