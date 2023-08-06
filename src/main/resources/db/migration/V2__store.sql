CREATE TABLE `store`
(
    `id`            BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
    `customer_id`   BIGINT(20) UNSIGNED NOT NULL                  COMMENT '사장님 id',
    `store_name`    VARCHAR(20)         NOT NULL                  COMMENT '가게 이름',
    `category`      VARCHAR(20)         NOT NULL                  COMMENT '가게가 속한 카테고리',
    `created_at`    DATETIME(6)         NOT NULL   DEFAULT CURRENT_TIMESTAMP(6),
    `last_modified` DATETIME(6)         NOT NULL   DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
    PRIMARY KEY (`id`),
    FOREIGN KEY (customer_id) REFERENCES customer (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT '가게 정보';