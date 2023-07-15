package dapanda.adapter.outbound.jpa.store;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreJpaRepository extends JpaRepository<StoreEntity, Long> {
}
