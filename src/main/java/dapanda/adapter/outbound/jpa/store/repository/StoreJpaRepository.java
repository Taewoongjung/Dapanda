package dapanda.adapter.outbound.jpa.store.repository;

import dapanda.adapter.outbound.jpa.store.StoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreJpaRepository extends JpaRepository<StoreEntity, Long> {
}
