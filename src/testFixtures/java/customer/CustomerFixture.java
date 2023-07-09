package customer;

import dapanda.domain.customer.Customer;

import java.time.LocalDateTime;

public class CustomerFixture {

    public static Customer CUSTOMER = Customer.of(
            1L,
            "홍길동",
            "abc@aaa.com",
            "1q2w3e4r",
            "01012345678",
            LocalDateTime.now(),
            LocalDateTime.now()
    );
}
