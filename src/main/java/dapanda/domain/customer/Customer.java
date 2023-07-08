package dapanda.domain.customer;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
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
        return new Customer(id, name, email, password, tel, createdAt, lastModified);
    }
}
