package dapanda.domain.common.error;

import lombok.Getter;

@Getter
public class NotFoundException extends NullPointerException {

    private final int code;

    public NotFoundException(final ErrorType errorType) {
        super(errorType.getMessage());
        this.code = errorType.getCode();
    }
}
