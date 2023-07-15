package dapanda.domain.store;

import dapanda.domain.store.Store;

import java.util.Optional;

public interface StoreRepository {

    public Store save(Store store);

    public Optional<Store> findById(long id);
}
