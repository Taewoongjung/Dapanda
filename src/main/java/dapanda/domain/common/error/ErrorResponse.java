package dapanda.domain.common.error;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class ErrorResponse {

    private int errorCode;
    private String message;
}
