package dapanda.domain.store.product;

import java.util.Optional;

public interface ProductRepository {

    public <T extends Product> T save(T product);

    public Optional<Product> findById(long id);
}
