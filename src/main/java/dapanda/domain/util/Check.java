package dapanda.domain.util;

import dapanda.domain.common.error.ErrorType;
import dapanda.domain.common.error.InvalidInputException;

import java.util.function.Predicate;

public class Check {

    public static <T> void require(final Predicate<T> predicate, final T target, final ErrorType errorType) {
        if (predicate.test(target)) {
            throw new InvalidInputException(errorType);
        }
    }

    public static void check(final boolean condition, final ErrorType errorType) {
        if (condition) {
            throw new InvalidInputException(errorType);
        }
    }
}
