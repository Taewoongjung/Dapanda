package dapanda.adapter.inbound.controller.store;

import dapanda.adapter.inbound.controller.request.WebRequest;
import org.springframework.web.bind.annotation.*;

@RestController
public class StoreController {

    @PostMapping(value = "/stores/{storeId}/products/{productId}")
    public void orderProduct(
            @PathVariable final long storeId,
            @PathVariable final long productId,
            @RequestBody final WebRequest.OrderProductWebRequestV1 webRequestV1
    ) {

    }
}
