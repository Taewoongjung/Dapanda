package dapanda.adapter.util;

import dapanda.adapter.common.ErrorType;
import dapanda.adapter.common.InvalidInputException;

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
