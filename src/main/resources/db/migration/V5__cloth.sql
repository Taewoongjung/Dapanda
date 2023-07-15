CREATE TABLE `cloth`
(
    `id`            BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
    `product_id`    BIGINT(20) UNSIGNED     NULL                  COMMENT '상픔 id',
    `name`          VARCHAR(20)         NOT NULL                  COMMENT '옷 이름',
    `brand_name`    VARCHAR(20)         NOT NULL                  COMMENT '옷 브랜드 이름',
    `price`         INT                 NOT NULL                  COMMENT '옷 상품 가격',
    `amount`        INT                 NOT NULL                  COMMENT '옷 상품 갯수',
    `is_use`        BIT(1)              NOT NULL                  COMMENT '옷 상품 사용 여부',
    `description`   VARCHAR(50)                                   COMMENT '옷 상품 설명',
    `created_at`    DATETIME(6)         NOT NULL   DEFAULT CURRENT_TIMESTAMP(6),
    `last_modified` DATETIME(6)         NOT NULL   DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT '의류 상품 정보';
