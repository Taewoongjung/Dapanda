package dapanda.application.store;

import dapanda.domain.common.NotFoundException;
import dapanda.domain.outbound.jpa.order.DeliveryOrderEntity;
import dapanda.domain.outbound.jpa.order.repository.DeliveryOrderJpaRepository;
import dapanda.domain.outbound.jpa.store.StoreEntity;
import dapanda.domain.outbound.jpa.store.repository.StoreJpaRepository;
import dapanda.application.store.dto.StoreServiceDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    public Optional<DeliveryOrderEntity> findOrder(final long storeId, final long orderId) {

        log.info("{} {}", storeId, orderId);

        return orderRepository.findById(orderId);
    }

    @Transactional(readOnly = true)
    public Optional<StoreEntity> findStore(final long storeId) {

        log.info("{} {}", storeId);

        Optional<StoreEntity> res = storeRepository.findById(storeId);

        System.out.println("@@@ = "+res.get().getCustomer().getId());

        return res;
    }
}
