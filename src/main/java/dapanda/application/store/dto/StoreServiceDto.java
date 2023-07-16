package dapanda.application.store.dto;

public class StoreServiceDto {

    public static record OrderDto(
            long storeId,
            long productId,
            int orderAmount
    ) { }
}
