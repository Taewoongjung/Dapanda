package dapanda.application.store;

import dapanda.adapter.common.NotFoundException;
import dapanda.application.store.dto.StoreServiceDto;
import dapanda.domain.store.StoreRepository;
import dapanda.domain.store.product.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static dapanda.adapter.common.ErrorType.NOT_FOUND_PRODUCT_INFO;
import static dapanda.adapter.common.ErrorType.NOT_FOUND_STORE_INFO;
import static dapanda.domain.store.StoreCategoryType.FOOD;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static store.StoreFixture.STORE;

class StoreServiceTest {

    private final StoreRepository storeRepository = mock(StoreRepository.class);
    private final ProductRepository productRepository = mock(ProductRepository.class);

    private final StoreService sut = new StoreService(
            storeRepository,
            productRepository
    );

    @Test
    @DisplayName("가게 정보가 없으면 음식을 주문할 수 없다.")
    void test1() {

        // given
        StoreServiceDto.OrderDto dto = new StoreServiceDto.OrderDto(1L, 10L, 2, FOOD.getTypeName());

        // when
        when(storeRepository.findById(dto.storeId())).thenReturn(null);

        // then
        assertThrows(NotFoundException.class,
                () -> sut.order(dto),
                NOT_FOUND_STORE_INFO.getMessage());
    }

    @Test
    @DisplayName("상품 정보가 없으면 음식을 주문할 수 없다.")
    void test2() {

        // given
        StoreServiceDto.OrderDto dto = new StoreServiceDto.OrderDto(1L, 10L, 2, FOOD.getTypeName());

        // when
        when(storeRepository.findById(dto.storeId())).thenReturn(Optional.of(STORE));
        when(productRepository.findById(dto.productId())).thenReturn(null);

        // then
        assertThrows(NotFoundException.class,
                () -> sut.order(dto),
                NOT_FOUND_PRODUCT_INFO.getMessage());
    }
}