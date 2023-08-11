package dapanda.domain.outbound.jpa.customer;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import dapanda.domain.outbound.jpa.BaseEntity;
import dapanda.domain.outbound.jpa.order.DeliveryOrderEntity;
import dapanda.domain.outbound.jpa.store.StoreEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
//@Entity
//@Table(name = "customer")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CustomerEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    private String password;
    private String tel;

    @JsonManagedReference
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    private List<StoreEntity> stores;

    @JsonBackReference
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    private List<DeliveryOrderEntity> orders;

    private CustomerEntity(
            final long id,
            final String name,
            final String email,
            final String password,
            final String tel
    ) {
        super(LocalDateTime.now(), LocalDateTime.now());

        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.tel = tel;
    }

    public static CustomerEntity of(
            final long id,
            final String name,
            final String email,
            final String password,
            final String tel
    ) {
        return new CustomerEntity(id, name, email, password, tel);
    }
}
