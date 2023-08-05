CREATE TABLE `food`
(
    `id`            BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
    `product_id`    BIGINT(20) UNSIGNED     NULL                  COMMENT '상품 id',
    `name`          VARCHAR(20)         NOT NULL                  COMMENT '음식 이름',
    `brand_name`    VARCHAR(20)         NOT NULL                  COMMENT '음식 브랜드 이름',
    `price`         INT                 NOT NULL                  COMMENT '음식 상품 가격',
    `amount`        INT                 NOT NULL                  COMMENT '음식 상품 갯수',
    `is_use`        BIT(1)              NOT NULL                  COMMENT '음식 상품 사용 여부',
    `description`   VARCHAR(50)                                   COMMENT '음식 상품 설명',
    `created_at`    DATETIME(6)         NOT NULL   DEFAULT CURRENT_TIMESTAMP(6),
    `last_modified` DATETIME(6)         NOT NULL   DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
    PRIMARY KEY (`id`),
    FOREIGN KEY (product_id) REFERENCES product (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT '음식 상품 정보';
