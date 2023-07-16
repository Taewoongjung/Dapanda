package dapanda.adapter.util;

import dapanda.adapter.outbound.jpa.customer.CustomerEntity;
import dapanda.adapter.outbound.jpa.order.OrderEntity;
import dapanda.adapter.outbound.jpa.store.StoreEntity;
import dapanda.adapter.outbound.jpa.store.product.ProductEntity;
import dapanda.adapter.outbound.jpa.store.product.cloth.ClothEntity;
import dapanda.adapter.outbound.jpa.store.product.food.FoodEntity;
import dapanda.domain.customer.Customer;
import dapanda.domain.order.Order;
import dapanda.domain.store.Store;
import dapanda.domain.store.product.Product;
import dapanda.domain.store.product.cloth.Cloth;
import dapanda.domain.store.product.food.Food;

import java.util.List;

public class ObjectConverter {

    // Customer
    public static Customer toCustomerPojo(final CustomerEntity entity) {
        return Customer.of(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getPassword(),
                entity.getTel(),
                entity.getCreatedAt(),
                entity.getLastModified()
        );
    }
    public static CustomerEntity toCustomerEntity(final Customer pojo) {
        return CustomerEntity.of(
                pojo.getId(),
                pojo.getName(),
                pojo.getEmail(),
                pojo.getPassword(),
                pojo.getTel()
        );
    }

    // Food
    public static Food toFoodPojo(final FoodEntity entity) {
        return Food.of(
                entity.getId(),
                entity.getName(),
                entity.getBrandName(),
                entity.getAmount(),
                entity.getPrice(),
                entity.isUse(),
                entity.getDescription(),
                entity.getCreatedAt(),
                entity.getLastModified()
        );
    }
    public static FoodEntity toFoodEntity(final Food pojo) {
        return FoodEntity.of(
                pojo.getId(),
                pojo.getBrandName(),
                pojo.getBrandName(),
                pojo.getAmount(),
                pojo.getPrice(),
                pojo.isUse(),
                pojo.getDescription()
        );
    }


    // Cloth
    public static Cloth toClothPojo(final ClothEntity entity) {
        return Cloth.of(
                entity.getId(),
                entity.getName(),
                entity.getBrandName(),
                entity.getAmount(),
                entity.getPrice(),
                entity.isUse(),
                entity.getDescription(),
                entity.getCreatedAt(),
                entity.getLastModified()
        );
    }
    public static ClothEntity toClothEntity(final Cloth pojo) {
        return ClothEntity.of(
                pojo.getId(),
                pojo.getName(),
                pojo.getBrandName(),
                pojo.getAmount(),
                pojo.getPrice(),
                pojo.isUse(),
                pojo.getDescription()
        );
    }


    // Product
    public static ProductEntity toProductEntity(final Product pojo) {
        ProductEntity entity = ProductEntity.of(
                pojo.getId(),
                toStoreEntity(pojo.getStore())
        );

        entity.setFoodsEntityList(pojo.getFoods());
        entity.setClothsEntityList(pojo.getCloths());

        return entity;
    }
    public static Product toProductPojo(final ProductEntity entity) {
        return Product.of(
                entity.getId(),
                toStorePojo(entity.getStore()),
                entity.getCreatedAt(),
                entity.getLastModified()
        );
    }


    // Store
    public static StoreEntity toStoreEntity(final Store pojo) {
        StoreEntity entity = StoreEntity.of(
                pojo.getId(),
                pojo.getStoreName(),
                pojo.getCategory()
        );

        entity.setCustomersPojoListToEntity(pojo.getCustomers());
        entity.setProductsPojoListToEntity(pojo.getProducts());
        entity.setOrdersPojoListToEntity(pojo.getOrders());

        return entity;
    }
    public static Store toStorePojo(final StoreEntity entity) {
        Store pojo = Store.of(
                entity.getId(),
                entity.getStoreName(),
                entity.getCategory(),
                entity.getCreatedAt(),
                entity.getLastModified()
        );

        entity.setOrdersEntityListToPojo(pojo.getOrders());
//        pojo.setOrders(orderPojoList);
//
        entity.setCustomersEntityListToPojo(pojo.getCustomers());
//        pojo.setCustomers(customerPojoList);
//
        entity.setProductsEntityListToPojo(pojo.getProducts());
//        pojo.setProducts(productPojoList);

        return pojo;
    }


    // Order
    public static OrderEntity toOrderEntity(final Order pojo) {
        return OrderEntity.of(
                pojo.getId(),
                toStoreEntity(pojo.getStore()),
                toProductEntity(pojo.getProduct()),
                toCustomerEntity(pojo.getCustomer()),
                pojo.getAmount()
        );
    }
    public static Order toOrderPojo(final OrderEntity entity) {
        return Order.of(
                entity.getId(),
                toStorePojo(entity.getStore()),
                toProductPojo(entity.getProduct()),
                toCustomerPojo(entity.getCustomer()),
                entity.getAmount()
        );
    }
}
