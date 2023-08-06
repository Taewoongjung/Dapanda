package dapanda.domain.outbound.jpa.store.categoryenum;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum StoreCategoryType {

    FOOD("food"),
    CLOTH("cloth")
    ;

    private final String typeName;

    public static StoreCategoryType ofTypeName(final String value) {
        return Arrays.stream(values())
                .filter(o -> value.equals(o.getTypeName()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("타입 없음"));
    }
}
