package dapanda.adapter.common;

import lombok.Getter;

@Getter
public class InvalidInputException extends RuntimeException {

    private final int code;

    public InvalidInputException(final ErrorType errorType) {
        super(errorType.getMessage());
        this.code = errorType.getCode();
    }
}
