//package dapanda.application.store.dto;
//
//import dapanda.domain.outbound.jpa.customer.CustomerEntity;
//import dapanda.domain.outbound.jpa.store.StoreEntity;
//import dapanda.domain.outbound.jpa.store.categoryenum.StoreCategoryType;
//import dapanda.domain.outbound.jpa.store.product.ProductEntity;
//
//import java.util.List;
//
//public class StoreServiceDto {
//
//    public static record OrderDto(long storeId, long productId, int orderAmount) { }
//    public static record FindStoreResponseDto(long storeId, String storeName, StoreCategoryType category, CustomerEntity customer, List<ProductEntity> products) { }
//    public static record FindOrderResponseDto(StoreEntity store, ProductEntity product, CustomerEntity customer) { }
//}