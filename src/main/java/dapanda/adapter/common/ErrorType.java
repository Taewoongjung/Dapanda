package dapanda.adapter.common;

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
    ;

    private final int code;
    private final String message;
}
