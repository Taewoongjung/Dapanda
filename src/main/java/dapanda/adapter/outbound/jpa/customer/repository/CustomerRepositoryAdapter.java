package dapanda.adapter.outbound.jpa.customer.repository;

import dapanda.adapter.outbound.jpa.customer.CustomerEntity;
import dapanda.adapter.util.ObjectConverter;
import dapanda.domain.customer.Customer;
import dapanda.domain.customer.CustomerRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static dapanda.adapter.util.ObjectConverter.toCustomerEntity;
import static dapanda.adapter.util.ObjectConverter.toCustomerPojo;

@Repository
@Getter
@RequiredArgsConstructor
public class CustomerRepositoryAdapter implements CustomerRepository {

    private final CustomerJpaRepository jpaRepository;

    @Override
    public Customer save(Customer customer) {
        CustomerEntity entity = toCustomerEntity(customer);
        jpaRepository.save(entity);
        return toCustomerPojo(entity);
    }

    @Override
    public Optional<Customer> findById(long id) {
        return jpaRepository.findById(id)
                .map(ObjectConverter::toCustomerPojo);
    }
}
