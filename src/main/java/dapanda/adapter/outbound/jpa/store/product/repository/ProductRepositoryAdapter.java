package dapanda.adapter.outbound.jpa.store.product.repository;

import dapanda.adapter.outbound.jpa.store.product.ProductEntity;
import dapanda.adapter.util.ObjectConverter;
import dapanda.domain.store.product.Product;
import dapanda.domain.store.product.ProductRepository;
import dapanda.domain.store.product.cloth.Cloth;
import dapanda.domain.store.product.food.Food;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static dapanda.adapter.util.ObjectConverter.*;
import static dapanda.domain.store.StoreCategoryType.CLOTH;

@Repository
@Getter
@RequiredArgsConstructor
public class ProductRepositoryAdapter implements ProductRepository {

    private final ProductJpaRepository jpaRepository;

    @Override
    public Product save(Product product) {
        ProductEntity entity = toProductEntity(product);
        jpaRepository.save(entity);
        return toProductPojo(entity);
    }

    @Override
    public Optional<Product> findById(long id) {
        return jpaRepository.findById(id).map(ObjectConverter::toProductPojo);
    }
}
