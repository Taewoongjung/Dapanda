package dapanda.application.store;

import dapanda.adapter.common.NotFoundException;
import dapanda.application.store.dto.StoreServiceDto;
import dapanda.domain.store.Store;
import dapanda.domain.store.StoreRepository;
import dapanda.domain.store.product.Product;
import dapanda.domain.store.product.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static dapanda.adapter.common.ErrorType.NOT_FOUND_PRODUCT_INFO;
import static dapanda.adapter.common.ErrorType.NOT_FOUND_STORE_INFO;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;
    private final ProductRepository productRepository;

    @Transactional
    public void order(final StoreServiceDto.OrderDto dto) {

        Optional<Store> store = getStoreInfoById(dto.storeId());
        Optional<Product> product = getProductInfoById(dto.productId());


    }

    private Optional<Store> getStoreInfoById(final long storeId) {
        Optional<Store> store = storeRepository.findById(storeId);

        if (store == null) {
            throw new NotFoundException(NOT_FOUND_STORE_INFO);
        }
        return store;
    }

    private Optional<Product> getProductInfoById(final long productId) {
        Optional<Product> product = productRepository.findById(productId);

        if (product == null) {
            throw new NotFoundException(NOT_FOUND_PRODUCT_INFO);
        }
        return product;
    }
}
