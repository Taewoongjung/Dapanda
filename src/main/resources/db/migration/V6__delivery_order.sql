CREATE TABLE `delivery_order`
(
    `id`            BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
    `store_id`      BIGINT(20) UNSIGNED NOT NULL                  COMMENT '주문한 가게 id',
    `product_id`    BIGINT(20) UNSIGNED NOT NULL                  COMMENT '주문 상품 id',
    `customer_id`   BIGINT(20) UNSIGNED NOT NULL                  COMMENT '주문한 고객 id',
    `amount`        INT                 NOT NULL                  COMMENT '주문한 상품 개수',
    `created_at`    DATETIME(6)         NOT NULL   DEFAULT CURRENT_TIMESTAMP(6),
    `last_modified` DATETIME(6)         NOT NULL   DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
    PRIMARY KEY (`id`),
    FOREIGN KEY (store_id) REFERENCES store (id),
    FOREIGN KEY (product_id) REFERENCES product (id),
    FOREIGN KEY (customer_id) REFERENCES customer (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT '주문 정보';
