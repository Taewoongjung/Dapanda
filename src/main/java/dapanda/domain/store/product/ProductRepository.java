package dapanda.domain.store.product;

import java.util.Optional;

public interface ProductRepository {

    public Product save(Product product);

    public Optional<Product> findById(long id);
}
