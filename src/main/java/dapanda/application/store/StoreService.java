package dapanda.application.store;

import dapanda.domain.common.NotFoundException;
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

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static dapanda.domain.common.ErrorType.NOT_FOUND_STORE_INFO;

@Service
@Slf4j
@RequiredArgsConstructor
public class StoreService {

    private final StoreJpaRepository storeRepository;
    private final DeliveryOrderJpaRepository orderRepository;

    @Transactional
    public void order(final StoreServiceDto.OrderDto dto) {

        StoreEntity store = getStoreInfoById(dto.storeId());
    }

    private StoreEntity getStoreInfoById(final long storeId) {
        return storeRepository.findById(storeId)
                .orElseThrow(() -> new NotFoundException(NOT_FOUND_STORE_INFO));
    }

    @Transactional(readOnly = true)
    public StoreServiceDto.FindOrderDto findOrder(final long storeId, final long orderId) {

        log.info("{} {}", storeId, orderId);

        Optional<DeliveryOrderEntity> order = orderRepository.findById(orderId);

        List<ProductEntity> products = order.get().getStore().getProducts().stream()
                .map(o -> ProductEntity.of(o.getId(), getFood(o.getFood()), getCloth(o.getCloth())))
                .collect(Collectors.toList());

        return new StoreServiceDto.FindOrderDto(getStore(order.get().getStore()), products); //
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
        StoreEntity storeEntity = StoreEntity.of(
                store.getId(),
                store.getStoreName(),
                store.getCategory()
        );
        return storeEntity;
    }

    @Transactional(readOnly = true)
    public StoreServiceDto.FindStoreDto findStore(final long storeId) {

        log.info("{}", storeId);

        Optional<StoreEntity> store = storeRepository.findById(storeId);

        CustomerEntity customer = getCustomerEntity(store.get().getCustomer());

        return new StoreServiceDto.FindStoreDto(customer, store.get().getProducts());
    }

    private CustomerEntity getCustomerEntity(CustomerEntity customer) {
        return CustomerEntity.of(
                customer.getId(),
                customer.getName(),
                customer.getEmail(),
                customer.getPassword(),
                customer.getTel()
        );
    }
}
