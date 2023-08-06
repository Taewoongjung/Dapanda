package dapanda.application.store.dto;

import dapanda.domain.outbound.jpa.customer.CustomerEntity;
import dapanda.domain.outbound.jpa.store.product.ProductEntity;

import java.util.List;

public class StoreServiceDto {

    public static record OrderDto(long storeId, long productId, int orderAmount) { }

    public static record FindStoreDto(CustomerEntity customer, List<ProductEntity> products) { }
}
