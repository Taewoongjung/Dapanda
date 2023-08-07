package dapanda.application.store;

import dapanda.domain.common.error.InvalidInputException;
import dapanda.domain.common.error.NotFoundException;
import dapanda.domain.outbound.jpa.customer.CustomerEntity;
import dapanda.domain.outbound.jpa.order.DeliveryOrderEntity;
import dapanda.domain.outbound.jpa.order.repository.DeliveryOrderJpaRepository;
import dapanda.domain.outbound.jpa.store.StoreEntity;
import dapanda.domain.outbound.jpa.store.product.ProductEntity;
import dapanda.domain.outbound.jpa.store.product.cloth.ClothEntity;
import dapanda.domain.outbound.jpa.store.product.food.FoodEntity;
import dapanda.domain.outbound.jpa.store.repository.StoreJpaRepository;
import dapanda.application.store.dto.StoreServiceDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static dapanda.domain.common.error.ErrorType.NOT_FOUND_ORDER_INFO;
import static dapanda.domain.common.error.ErrorType.NOT_FOUND_STORE_INFO;

@Service
@Slf4j
@RequiredArgsConstructor
public class StoreService {

    private final StoreJpaRepository storeRepository;
    private final DeliveryOrderJpaRepository orderRepository;

    @Transactional
    public void order(final StoreServiceDto.OrderDto dto) throws Exception {

        StoreEntity store = getStoreInfoById(dto.storeId());


    }

    private StoreEntity getStoreInfoById(final long storeId) {
        return storeRepository.findById(storeId)
                .orElseThrow(() -> new NotFoundException(NOT_FOUND_STORE_INFO));
    }

    @Transactional(readOnly = true)
    public StoreServiceDto.FindOrderResponseDto findOrder(final long storeId, final long orderId) throws Exception{

        log.info("{} {}", storeId, orderId);

        Optional<DeliveryOrderEntity> order = orderRepository.findById(orderId);

        if (order.isEmpty()) {
            throw new InvalidInputException(NOT_FOUND_ORDER_INFO);
        }

        ProductEntity product = getProductListFromDeliveryOrder(order);
        StoreEntity store = getStore(order.get().getStore());
        CustomerEntity customer = getCustomerFromDeliveryOrder(order);

        return new StoreServiceDto.FindOrderResponseDto(store, product, customer);
    }

    private ProductEntity getProductListFromDeliveryOrder(final Optional<DeliveryOrderEntity> order) {

        if (order.isPresent()) {
            ProductEntity product = order.get().getProduct();
            return ProductEntity.of(product.getId(), product.getFood(), product.getCloth());
        } else {
            throw new InvalidInputException(NOT_FOUND_ORDER_INFO);
        }
    }
    private CustomerEntity getCustomerFromDeliveryOrder(final Optional<DeliveryOrderEntity> order) {

        if (order.isPresent()) {
            CustomerEntity customer = order.get().getCustomer();
            return CustomerEntity.of(customer.getId(), customer.getName(), customer.getEmail(), customer.getPassword(), customer.getTel());
        } else {
            throw new InvalidInputException(NOT_FOUND_ORDER_INFO);
        }
    }
    private FoodEntity getFood(final FoodEntity food) {
        return FoodEntity.of(
                food.getId(),
                food.getName(),
                food.getBrandName(),
                food.getAmount(),
                food.getPrice(),
                food.isUse(),
                food.getDescription()
        );
    }
    private ClothEntity getCloth(final ClothEntity cloth) {
        return ClothEntity.of(
                cloth.getId(),
                cloth.getName(),
                cloth.getBrandName(),
                cloth.getAmount(),
                cloth.getPrice(),
                cloth.isUse(),
                cloth.getDescription()
        );
    }

    private StoreEntity getStore(final StoreEntity store) {
        return StoreEntity.of(
                store.getId(),
                store.getStoreName(),
                store.getCategory()
        );
    }

    @Transactional(readOnly = true)
    public StoreServiceDto.FindStoreResponseDto findStore(final long storeId) throws Exception {

        log.info("{}", storeId);

        Optional<StoreEntity> store = storeRepository.findById(storeId);

        if (store.isEmpty()) {
            throw new InvalidInputException(NOT_FOUND_STORE_INFO);
        }

        CustomerEntity customer = getCustomerFromStore(store);
        StoreEntity storeEntity = store.get();

        return new StoreServiceDto.FindStoreResponseDto(
                storeEntity.getId(),
                storeEntity.getStoreName(),
                storeEntity.getCategory(),
                customer,
                storeEntity.getProducts());
    }

    private CustomerEntity getCustomerFromStore(final Optional<StoreEntity> store) {
        CustomerEntity customer = null;
        if (store.isPresent()) {
            customer = mapCustomerEntity(store.get().getCustomer());
        }

        return customer;
    }

    private CustomerEntity mapCustomerEntity(final CustomerEntity customer) {
        return CustomerEntity.of(
                customer.getId(),
                customer.getName(),
                customer.getEmail(),
                customer.getPassword(),
                customer.getTel()
        );
    }
}
