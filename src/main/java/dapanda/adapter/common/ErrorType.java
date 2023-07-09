package dapanda.adapter.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorType {

    INVALID_CUSTOMER_NAME(1001, "이름은 필수값 입니다."),
    INVALID_CUSTOMER_EMAIL(1002, "이메일은 필수값 입니다."),
    INVALID_CUSTOMER_TEL(1003, "전화번호는 필수값 입니다.")
    ;

    private final int code;
    private final String message;
}
