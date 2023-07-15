package dapanda.domain.customer;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

import static dapanda.adapter.common.ErrorType.*;
import static dapanda.adapter.util.Check.require;

@Getter
@ToString
public class Customer {

    private final long id;
    private final String name;
    private final String email;
    private final String password;
    private final String tel;
    private final LocalDateTime createdAt;
    private final LocalDateTime lastModified;

    private Customer(
            final long id,
            final String name,
            final String email,
            final String password,
            final String tel,
            final LocalDateTime createdAt,
            final LocalDateTime lastModified
    ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.tel = tel;
        this.createdAt = createdAt;
        this.lastModified = lastModified;
    }

    public static Customer of(
            final long id,
            final String name,
            final String email,
            final String password,
            final String tel,
            final LocalDateTime createdAt,
            final LocalDateTime lastModified
    ) {
        require(o -> name == null, name, INVALID_CUSTOMER_NAME);
        require(o -> email == null, email, INVALID_CUSTOMER_EMAIL);
        require(o -> tel == null, tel, INVALID_CUSTOMER_TEL);

        return new Customer(id, name, email, password, tel, createdAt, lastModified);
    }
}
