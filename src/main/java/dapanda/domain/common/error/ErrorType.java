package dapanda.domain.common.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorType {

    INVALID_CUSTOMER_NAME(1001, "이름은 필수값 입니다."),
    INVALID_CUSTOMER_EMAIL(1002, "이메일은 필수값 입니다."),
    INVALID_CUSTOMER_TEL(1003, "전화번호는 필수값 입니다."),

    INVALID_STORE_NAME(2001, "가게이름은 필수값 입니다."),
    INVALID_STORE_CATEGORY(2002, "가게 카테고리는 필수값 입니다."),
    INVALID_STORE_CEO_ID(2003, "가게 사장님 ID는 필수값 입니다."),

    INVALID_PRODUCT_NAME(3001, "상품 이름은 필수값 입니다."),
    INVALID_PRODUCT_AMOUNT(3002, "상품 수량은 필수값 입니다."),
    INVALID_PRODUCT_PRICE(3003, "상품 가격은 필수값 입니다."),

    NOT_FOUND_STORE_INFO(4001, "가게 정보가 없습니다."),
    NOT_FOUND_PRODUCT_INFO(4002, "상품 정보가 없습니다."),
    NOT_FOUND_ORDER_INFO(4003, "주문 정보가 없습니다."),
    NOT_FOUND_CUSTOMER_INFO(4004, "고객 정보가 없습니다.")
    ;

    private final int code;
    private final String message;
}
