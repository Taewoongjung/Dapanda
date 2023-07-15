package dapanda.adapter.outbound.jpa.store.repository;

import dapanda.adapter.outbound.jpa.store.StoreEntity;
import dapanda.adapter.util.ObjectConverter;
import dapanda.domain.store.Store;
import dapanda.domain.store.StoreRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static dapanda.adapter.util.ObjectConverter.toStoreEntity;
import static dapanda.adapter.util.ObjectConverter.toStorePojo;

@Repository
@Getter
@RequiredArgsConstructor
public class StoreRepositoryAdapter implements StoreRepository {

    private final StoreJpaRepository jpaRepository;

    @Override
    public Store save(Store store) {
        StoreEntity entity = toStoreEntity(store);
        jpaRepository.save(entity);
        return toStorePojo(entity);
    }

    @Override
    public Optional<Store> findById(long id) {
        return jpaRepository.findById(id)
                .map(ObjectConverter::toStorePojo);
    }
}
