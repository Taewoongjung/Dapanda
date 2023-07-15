package dapanda.adapter.outbound.jpa.customer.repository;

import dapanda.adapter.outbound.jpa.customer.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerJpaRepository extends JpaRepository<CustomerEntity, Long> {
}
