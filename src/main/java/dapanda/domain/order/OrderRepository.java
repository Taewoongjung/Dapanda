package dapanda.domain.order;

import java.util.Optional;

public interface OrderRepository {

    public Order save(Order order);

    public Optional<Order> findById(long id);
}
