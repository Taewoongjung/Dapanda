//package dapanda.domain.outbound.jpa.store;
//
//import com.fasterxml.jackson.annotation.JsonBackReference;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonManagedReference;
//import dapanda.domain.outbound.jpa.BaseEntity;
//import dapanda.domain.outbound.jpa.customer.CustomerEntity;
//import dapanda.domain.outbound.jpa.order.DeliveryOrderEntity;
//import dapanda.domain.outbound.jpa.store.categoryenum.StoreCategoryType;
//import dapanda.domain.outbound.jpa.store.product.ProductEntity;
//import jakarta.persistence.*;
//import lombok.AccessLevel;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//@Getter
////@Entity
////@Table(name = "store")
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
////@Convert(converter = StoreCategoryTypeConverter.class, attributeName = "category")
//public class StoreEntity extends BaseEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//
//    @JsonBackReference
//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
//    @JoinColumn(name = "customer_id", referencedColumnName = "id")
//    private CustomerEntity customer;
//
//    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
//    private List<ProductEntity> products = new ArrayList<>();
//
//    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
//    private List<DeliveryOrderEntity> order = new ArrayList<>();
//
//    private String storeName;
//
//    private StoreCategoryType category;
//
//    private StoreEntity(
//            final long id,
//            final String storeName,
//            final StoreCategoryType category
//    ) {
//        super(LocalDateTime.now(), LocalDateTime.now());
//
//        this.id = id;
//        this.storeName = storeName;
//        this.category = category;
//    }
//
//    public static StoreEntity of(
//            final long id,
//            final String storeName,
//            final StoreCategoryType category
//    ) {
//        return new StoreEntity(id, storeName, category);
//    }
//}
