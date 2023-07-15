package dapanda.domain.customer;

import dapanda.domain.customer.Customer;

import java.util.Optional;

public interface CustomerRepository {

    public Customer save(Customer customer);

    public Optional<Customer> findById(long id);
}
