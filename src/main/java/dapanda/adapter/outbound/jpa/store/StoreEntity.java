package dapanda.adapter.outbound.jpa.store;

import dapanda.adapter.outbound.jpa.BaseEntity;
import dapanda.adapter.outbound.jpa.customer.CustomerEntity;
import dapanda.adapter.outbound.jpa.order.OrderEntity;
import dapanda.adapter.outbound.jpa.store.product.ProductEntity;
import dapanda.domain.customer.Customer;
import dapanda.domain.order.Order;
import dapanda.domain.store.Store;
import dapanda.domain.store.StoreCategoryType;
import dapanda.domain.store.product.Product;
import dapanda.domain.store.product.cloth.Cloth;
import dapanda.domain.store.product.food.Food;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static dapanda.adapter.util.ObjectConverter.*;

@Getter
@Entity
@ToString
@Table(name = "store")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StoreEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CustomerEntity> customers = new ArrayList<>();

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductEntity> products = new ArrayList<>();

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderEntity> orders = new ArrayList<>();

    private String storeName;

    @Enumerated(value = EnumType.STRING)
    private StoreCategoryType category;

    private StoreEntity(
            final long id,
            final String storeName,
            final StoreCategoryType category
    ) {
        super(LocalDateTime.now(), LocalDateTime.now());

        this.id = id;
        this.storeName = storeName;
        this.category = category;
    }

    public static StoreEntity of(
            final long id,
            final String storeName,
            final StoreCategoryType category
    ) {
        return new StoreEntity(id, storeName, category);
    }

    public void setCustomersPojoListToEntity(final List<Customer> pojo) {

        if (pojo == null) return;  // 에러 던지기

        pojo.forEach(pojoDomain -> {
            customers.add(
                toCustomerEntity(Customer.of(
                    pojoDomain.getId(),
                    pojoDomain.getName(),
                    pojoDomain.getEmail(),
                    pojoDomain.getPassword(),
                    pojoDomain.getTel(),
                    pojoDomain.getCreatedAt(),
                    pojoDomain.getLastModified()
                ))
            );
        });
    }

    public void setProductsPojoListToEntity(final List<Product> pojo) {

        if (pojo == null) return;  // 에러 던지기

        pojo.forEach(pojoDomain -> {
            ProductEntity entity = toProductEntity(Product.of(
                    pojoDomain.getId(),
                    pojoDomain.getStore(),
                    pojoDomain.getCreatedAt(),
                    pojoDomain.getLastModified()
            ));

            entity.setFoodsEntityList(pojoDomain.getFoods());
            entity.setClothsEntityList(pojoDomain.getCloths());

            products.add(entity);
        });
    }

    public void setOrdersPojoListToEntity(final List<Order> pojo) {

        if (pojo == null) return;  // 에러 던지기

        pojo.forEach(pojoDomain -> {
            orders.add(toOrderEntity(Order.of(
                            pojoDomain.getId(),
                            pojoDomain.getStore(),
                            pojoDomain.getProduct(),
                            pojoDomain.getCustomer(),
                            pojoDomain.getAmount()
                    ))
            );
        });
    }

    public void setOrdersEntityListToPojo(
            List<Order> pojo
    ) {

        orders.forEach(entityDomain -> {

            Store storePojo = Store.of(
                    entityDomain.getStore().getId(),
                    entityDomain.getStore().getStoreName(),
                    entityDomain.getStore().getCategory(),
                    entityDomain.getStore().getCreatedAt(),
                    entityDomain.getStore().getLastModified()
            );

            Customer customerPojo = Customer.of(
                    entityDomain.getCustomer().getId(),
                    entityDomain.getCustomer().getName(),
                    entityDomain.getCustomer().getEmail(),
                    entityDomain.getCustomer().getPassword(),
                    entityDomain.getCustomer().getTel(),
                    entityDomain.getCustomer().getCreatedAt(),
                    entityDomain.getCustomer().getLastModified()
            );

            Product product = Product.of(
                    entityDomain.getProduct().getId(),
                    storePojo,
                    null,
                    null,
                    entityDomain.getProduct().getCreatedAt(),
                    entityDomain.getProduct().getLastModified());

            pojo.add(Order.of(
                    entityDomain.getId(),
                    storePojo,
                    product,
                    customerPojo,
                    entityDomain.getAmount()
            ));
        });
    }

    public void setCustomersEntityListToPojo(List<Customer> pojo) {

        customers.forEach(entityDomain -> {
            pojo.add(Customer.of(
                    entityDomain.getId(),
                    entityDomain.getName(),
                    entityDomain.getEmail(),
                    entityDomain.getPassword(),
                    entityDomain.getTel(),
                    entityDomain.getCreatedAt(),
                    entityDomain.getLastModified()
            ));
        });
    }

    public void setProductsEntityListToPojo(List<Product> pojo) {

        products.forEach(entityDomain -> {

            Store storePojo = Store.of(
                    entityDomain.getStore().getId(),
                    entityDomain.getStore().getStoreName(),
                    entityDomain.getStore().getCategory(),
                    entityDomain.getStore().getCreatedAt(),
                    entityDomain.getStore().getLastModified()
            );

            List<Food> foodList = entityDomain.getFoods().stream().map(o -> Food.of(
                    o.getId(),
                    o.getName(),
                    o.getBrandName(),
                    o.getAmount(),
                    o.getPrice(),
                    o.isUse(),
                    o.getDescription(),
                    o.getCreatedAt(),
                    o.getLastModified()
            )).toList();

            List<Cloth> clothList = entityDomain.getCloths().stream().map(o -> Cloth.of(
                    o.getId(),
                    o.getName(),
                    o.getBrandName(),
                    o.getAmount(),
                    o.getPrice(),
                    o.isUse(),
                    o.getDescription(),
                    o.getCreatedAt(),
                    o.getLastModified()
            )).toList();

            pojo.add(Product.of(
                    entityDomain.getId(),
                    storePojo,
                    foodList,
                    clothList,
                    entityDomain.getCreatedAt(),
                    entityDomain.getLastModified()
            ));
        });
    }
}
