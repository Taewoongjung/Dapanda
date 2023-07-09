package dapanda.domain.customer;

import dapanda.adapter.common.InvalidInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static customer.CustomerFixture.CUSTOMER;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Customer를")
class CustomerTest {

    @Test
    @DisplayName("생성할 수 있다.")
    void test1() {
        assertDoesNotThrow(() -> Customer.of(
                CUSTOMER.getId(),
                CUSTOMER.getName(),
                CUSTOMER.getEmail(),
                CUSTOMER.getPassword(),
                CUSTOMER.getTel(),
                CUSTOMER.getCreatedAt(),
                CUSTOMER.getLastModified()
        ));
    }

    @Test
    @DisplayName("필수값 이름이 없으면 생성할 수 없다.")
    void test2() {
        assertThatThrownBy(() -> Customer.of(
                CUSTOMER.getId(),
                null,
                CUSTOMER.getEmail(),
                CUSTOMER.getPassword(),
                CUSTOMER.getTel(),
                CUSTOMER.getCreatedAt(),
                CUSTOMER.getLastModified()
        ))
                .isInstanceOf(InvalidInputException.class)
                .hasMessage("이름은 필수값 입니다.");
    }

    @Test
    @DisplayName("필수값 이메일이 없으면 생성할 수 없다.")
    void test3() {
        assertThatThrownBy(() -> Customer.of(
                CUSTOMER.getId(),
                CUSTOMER.getName(),
                null,
                CUSTOMER.getPassword(),
                CUSTOMER.getTel(),
                CUSTOMER.getCreatedAt(),
                CUSTOMER.getLastModified()
        ))
                .isInstanceOf(InvalidInputException.class)
                .hasMessage("이메일은 필수값 입니다.");
    }

    @Test
    @DisplayName("필수값 전화번호가 없으면 생성할 수 없다.")
    void test4() {
        assertThatThrownBy(() -> Customer.of(
                CUSTOMER.getId(),
                CUSTOMER.getName(),
                CUSTOMER.getEmail(),
                CUSTOMER.getPassword(),
                null,
                CUSTOMER.getCreatedAt(),
                CUSTOMER.getLastModified()
        ))
                .isInstanceOf(InvalidInputException.class)
                .hasMessage("전화번호는 필수값 입니다.");
    }
}
