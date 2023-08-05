package dapanda.domain.util;

import dapanda.domain.common.ErrorType;
import dapanda.domain.common.InvalidInputException;

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
