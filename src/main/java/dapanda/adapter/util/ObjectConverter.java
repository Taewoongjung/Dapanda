package dapanda.adapter.util;

import dapanda.adapter.outbound.jpa.customer.CustomerEntity;
import dapanda.adapter.outbound.jpa.store.StoreEntity;
import dapanda.adapter.outbound.jpa.store.product.food.FoodEntity;
import dapanda.domain.customer.Customer;
import dapanda.domain.store.Store;
import dapanda.domain.store.product.food.Food;

public class ObjectConverter {

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


    public static Food toFoodPojo(final FoodEntity entity) {
        return Food.of(
                entity.getId(),
                entity.getName(),
                entity.getBrandName(),
                entity.getAmount(),
                toStorePojo(entity.getStore()),
                entity.getPrice(),
                entity.isUse(),
                entity.getDescription(),
                entity.getCreatedAt(),
                entity.getLastModified()
        );
    }
    public FoodEntity toFoodEntity(final Food pojo) {
        return FoodEntity.of(
                pojo.getId(),
                pojo.getName(),
                pojo.getBrandName(),
                pojo.getAmount(),
                pojo.getPrice(),
                pojo.isUse(),
                pojo.getDescription()
        );
    }

    public static StoreEntity toStoreEntity(final Store pojo) {
        return StoreEntity.of(
                pojo.getId(),
                pojo.getStoreName(),
                pojo.getCategory()
        );
    }
    public static Store toStorePojo(final StoreEntity entity) {
        return Store.of(
                entity.getId(),
                entity.getStoreName(),
                entity.getCategory(),
                entity.getCreatedAt(),
                entity.getLastModified()
        );
    }
}
