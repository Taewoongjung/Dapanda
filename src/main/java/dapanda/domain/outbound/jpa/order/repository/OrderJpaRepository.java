package dapanda.domain.outbound.jpa.order.repository;

import dapanda.domain.outbound.jpa.order.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderJpaRepository extends JpaRepository<OrderEntity, Long> {
}
