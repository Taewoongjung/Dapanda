package dapanda.adapter.outbound.jpa.order.repository;

import dapanda.adapter.outbound.jpa.order.OrderEntity;
import dapanda.adapter.util.ObjectConverter;
import dapanda.domain.order.Order;
import dapanda.domain.order.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static dapanda.adapter.util.ObjectConverter.toOrderEntity;
import static dapanda.adapter.util.ObjectConverter.toOrderPojo;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryAdapter implements OrderRepository {

    private final OrderJpaRepository jpaRepository;

    @Override
    public Order save(Order order) {
        OrderEntity entity = toOrderEntity(order);
        jpaRepository.save(entity);
        return toOrderPojo(entity);
    }

    @Override
    public Optional<Order> findById(long id) {
        return jpaRepository.findById(id).map(ObjectConverter::toOrderPojo);
    }
}
