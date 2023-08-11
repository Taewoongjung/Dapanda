package dapanda.application.store;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

class StoreServiceTest {

//    private final StoreJpaRepository storeRepository = mock(StoreJpaRepository.class);
////    private final ProductRepository productRepository = mock(ProductRepository.class);
//
//    private final StoreService sut = new StoreService(
//            storeRepository
////            productRepository
//    );

    @Test
    @DisplayName("가게 정보가 없으면 음식을 주문할 수 없다.")
    void test1() {

//        // given
//        StoreServiceDto.OrderDto dto = new StoreServiceDto.OrderDto(1L, 10L, 2, FOOD.getTypeName());
//
//        // when
//        when(storeRepository.findById(dto.storeId())).thenReturn(null);
//
//        // then
//        assertThrows(NotFoundException.class,
//                () -> sut.order(dto),
//                NOT_FOUND_STORE_INFO.getMessage());
    }

    @Test
    @DisplayName("상품 정보가 없으면 음식을 주문할 수 없다.")
    void test2() {

        // given
//        StoreServiceDto.OrderDto dto = new StoreServiceDto.OrderDto(1L, 10L, 2, FOOD.getTypeName());
//
//        // when
//        when(storeRepository.findById(dto.storeId())).thenReturn(Optional.of(STORE));
//        when(productRepository.findById(dto.productId())).thenReturn(null);
//
//        // then
//        assertThrows(NotFoundException.class,
//                () -> sut.order(dto),
//                NOT_FOUND_PRODUCT_INFO.getMessage());
    }
}