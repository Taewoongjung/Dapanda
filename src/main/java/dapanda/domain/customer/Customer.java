package dapanda.domain.customer;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Customer {

    private final long id;
    private final String name;
    private final String email;
    private final String password;
    private final String tel;
    private final String createdAt;
    private final String updatedAt;
}
