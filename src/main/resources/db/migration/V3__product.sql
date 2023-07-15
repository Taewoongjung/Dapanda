CREATE TABLE `product`
(
    `id`            BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
    `store_id`      BIGINT(20) UNSIGNED NOT NULL                  COMMENT '가게 id',
    `food_id`       BIGINT(20) UNSIGNED     NULL                  COMMENT '상품(음식) id',
    `cloth_id`      BIGINT(20) UNSIGNED     NULL                  COMMENT '상품(의류) id',
    `created_at`    DATETIME(6)         NOT NULL   DEFAULT CURRENT_TIMESTAMP(6),
    `last_modified` DATETIME(6)         NOT NULL   DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
    PRIMARY KEY (`id`),
    FOREIGN KEY (`store_id`) REFERENCES store (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT '가게에서 소유하고 있는 상품 정보';
