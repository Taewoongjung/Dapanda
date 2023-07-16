package dapanda.adapter.outbound.jpa.order.repository;

import dapanda.adapter.outbound.jpa.order.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderJpaRepository extends JpaRepository<OrderEntity, Long> {
}
