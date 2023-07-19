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

import java.util.ArrayList;
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
        pojo.setOrders(toOrderPojoList(entity.getOrders()));

        entity.setCustomersEntityListToPojo(pojo.getCustomers());
        pojo.setCustomers(toCustomerPojoList(entity.getCustomers()));

        entity.setProductsEntityListToPojo(pojo.getProducts());
        pojo.setProducts(toProductPojoList(entity.getProducts()));

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

    public static List<Order> toOrderPojoList(final List<OrderEntity> entities) {
        List<Order> orders = new ArrayList<>();

        entities.forEach(
                o -> orders.add(Order.of(
                    o.getId(),
                    (Store.of(
                            o.getStore().getId(),
                            o.getStore().getStoreName(),
                            o.getStore().getCategory(),
                            o.getStore().getCreatedAt(),
                            o.getStore().getLastModified()
                    )),
                    (Product.of(
                            o.getProduct().getId(),
                            Store.of(
                                    o.getProduct().getStore().getId(),
                                    o.getProduct().getStore().getStoreName(),
                                    o.getProduct().getStore().getCategory(),
                                    o.getProduct().getStore().getCreatedAt(),
                                    o.getProduct().getStore().getLastModified()
                            ),
                            toFoodPojoList(o.getProduct().getFoods()),
                            toClothPojoList(o.getProduct().getCloths()),
                            o.getProduct().getCreatedAt(),
                            o.getProduct().getLastModified()
                    )),
                toCustomerPojo(o.getCustomer()),
                    o.getAmount()
            ))
        );

        return orders;
    }

    public static List<Customer> toCustomerPojoList(final List<CustomerEntity> entities) {

        List<Customer> customers = new ArrayList<>();

        entities.forEach(
                o -> customers.add(Customer.of(
                        o.getId(),
                        o.getName(),
                        o.getEmail(),
                        o.getPassword(),
                        o.getTel(),
                        o.getCreatedAt(),
                        o.getLastModified()
                )));

        return customers;
    }

    public static List<Product> toProductPojoList(final List<ProductEntity> entities) {

        List<Product> products = new ArrayList<>();

        entities.forEach(
                o -> products.add(Product.of(
                        o.getId(),
                        null,
                        toFoodPojoList(o.getFoods()),
                        toClothPojoList(o.getCloths()),
                        o.getCreatedAt(),
                        o.getLastModified()
                ))
        );

        return products;
    }

    private static List<Food> toFoodPojoList(final List<FoodEntity> entities) {

        List<Food> foods = new ArrayList<>();

        entities.forEach(
                o -> foods.add(Food.of(
                        o.getId(),
                        o.getName(),
                        o.getBrandName(),
                        o.getAmount(),
                        o.getPrice(),
                        o.isUse(),
                        o.getDescription(),
                        o.getCreatedAt(),
                        o.getLastModified()
                ))
        );

        return foods;
    }

    private static List<Cloth> toClothPojoList(final List<ClothEntity> entities) {

        List<Cloth> cloths = new ArrayList<>();

        entities.forEach(
                o -> cloths.add(Cloth.of(
                        o.getId(),
                        o.getName(),
                        o.getBrandName(),
                        o.getAmount(),
                        o.getPrice(),
                        o.isUse(),
                        o.getDescription(),
                        o.getCreatedAt(),
                        o.getLastModified()
                ))
        );

        return cloths;
    }
}
