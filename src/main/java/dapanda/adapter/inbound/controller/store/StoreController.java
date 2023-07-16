package dapanda.adapter.inbound.controller.store;

import dapanda.adapter.inbound.controller.request.WebRequest;
import dapanda.application.store.StoreService;
import dapanda.application.store.dto.StoreServiceDto;
import dapanda.domain.order.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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
    public Order getOrder(
            @PathVariable final long storeId,
            @PathVariable final long orderId
    ) {
        log.info("{} {}", storeId, orderId);

        return storeService.findOrder(storeId, orderId);
    }
}
