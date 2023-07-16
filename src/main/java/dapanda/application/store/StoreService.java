package dapanda.application.store;

import dapanda.adapter.common.NotFoundException;
import dapanda.application.store.dto.StoreServiceDto;
import dapanda.domain.customer.Customer;
import dapanda.domain.order.Order;
import dapanda.domain.order.OrderRepository;
import dapanda.domain.store.Store;
import dapanda.domain.store.StoreRepository;
import dapanda.domain.store.product.Product;
import dapanda.domain.store.product.ProductRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static dapanda.adapter.common.ErrorType.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    @Transactional
    public void order(final StoreServiceDto.OrderDto dto) {

        log.info("{}", dto);

        Store store = getStoreInfoById(dto.storeId());
        Product product = getProductInfoById(dto.productId());

        Customer customer = Customer.of(
                1L,
                "홍길동",
                "a@a.com",
                "aaa",
                "010-1111-2222",
                LocalDateTime.now(), LocalDateTime.now()
        );
        orderRepository.save(Order.of(
                store,
                product,
                customer,
                dto.orderAmount()
        ));
    }

    private Store getStoreInfoById(final long storeId) {
         return storeRepository.findById(storeId)
                .orElseThrow(() -> new NotFoundException(NOT_FOUND_STORE_INFO));
    }

    private Product getProductInfoById(final long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new NotFoundException(NOT_FOUND_PRODUCT_INFO));
    }


    @Transactional(readOnly = true)
    public Order findOrder(final long storeId, final long orderId) {

        log.info("{} {}", storeId, orderId);

        Store store = getStoreInfoById(storeId);
        return store.getOrderById(orderId);
    }

    private Order getOrderInfoById(final long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new NotFoundException(NOT_FOUND_ORDER_INFO));
    }
}
