package dapanda.domain.outbound.jpa.store.repository;

import dapanda.domain.outbound.jpa.store.StoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreJpaRepository extends JpaRepository<StoreEntity, Long> {
}
