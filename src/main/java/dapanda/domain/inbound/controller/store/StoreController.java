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

//    @PostMapping(value = "/stores/{storeId}/products/{productId}")
//    public ResponseEntity<Boolean> order(
//            @PathVariable final long storeId,
//            @PathVariable final long productId,
//            @RequestBody final WebRequest.OrderProductWebRequestV1 webRequestV1
//    ) throws Exception {
//        log.info("{}", webRequestV1);
//
//        return ResponseEntity.status(HttpStatus.OK).body(storeService.order(new StoreServiceDto.OrderDto(
//                storeId,
//                productId,
//                webRequestV1.orderAmount()
//        )));
//    }
//
//    @GetMapping(value = "/stores/{storeId}/orders/{orderId}")
//    public ResponseEntity<StoreServiceDto.FindOrderResponseDto> getOrder(
//            @PathVariable final long storeId,
//            @PathVariable final long orderId) throws Exception{
//        log.info("{} {}", storeId, orderId);
//
//        return ResponseEntity.status(HttpStatus.OK).body(storeService.findOrder(storeId, orderId));
//    }
//
//    @GetMapping(value = "/stores/{storeId}")
//    public ResponseEntity<StoreServiceDto.FindStoreResponseDto> getStore(
//            @PathVariable final long storeId) throws Exception {
//        log.info("{}", storeId);
//
//        return ResponseEntity.status(HttpStatus.OK).body(storeService.findStore(storeId));
//    }
}
