package dapanda.domain.inbound.controller.store;

import dapanda.domain.inbound.controller.request.WebRequest;
import dapanda.domain.outbound.jpa.order.DeliveryOrderEntity;
import dapanda.domain.outbound.jpa.store.StoreEntity;
import dapanda.application.store.StoreService;
import dapanda.application.store.dto.StoreServiceDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;

    @PostMapping(value = "/stores/{storeId}/products/{productId}")
    public void order(
            @PathVariable final long storeId,
            @PathVariable final long productId,
            @RequestBody final WebRequest.OrderProductWebRequestV1 webRequestV1
    ) {
        log.info("{}", webRequestV1);

        storeService.order(new StoreServiceDto.OrderDto(
                storeId,
                productId,
                webRequestV1.orderAmount()
        ));
    }

    @GetMapping(value = "/stores/{storeId}/orders/{orderId}")
    public Optional<DeliveryOrderEntity> getOrder(
            @PathVariable final long storeId,
            @PathVariable final long orderId
    ) {
        log.info("{} {}", storeId, orderId);

        return storeService.findOrder(storeId, orderId);
    }

    @GetMapping(value = "/stores/{storeId}")
    public ResponseEntity<StoreServiceDto.FindStoreDto> getStore(@PathVariable final long storeId) {
        log.info("{}", storeId);

        return ResponseEntity.status(HttpStatus.OK).body(storeService.findStore(storeId));
    }
}
