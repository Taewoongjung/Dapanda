CREATE TABLE `product`
(
    `id`            BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
    `name`          VARCHAR(20)         NOT NULL                  COMMENT '상품 이름',
    `brand_name`    VARCHAR(20)         NOT NULL                  COMMENT '상품 브랜드 이름',
    `price`         VARCHAR(20)         NOT NULL                  COMMENT '상품 가격',
    `is_use`        VARCHAR(20)         NOT NULL                  COMMENT '상품 사용 여부',
    `created_at`    DATETIME(6)         NOT NULL   DEFAULT CURRENT_TIMESTAMP(6),
    `last_modified` DATETIME(6)         NOT NULL   DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT '상품 정보';