package dapanda.adapter.outbound.jpa.store.product.repository;

import dapanda.adapter.outbound.jpa.store.product.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJpaRepository extends JpaRepository<ProductEntity, Long> {
}
