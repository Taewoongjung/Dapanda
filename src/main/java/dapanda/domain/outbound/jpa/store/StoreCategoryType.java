package dapanda.domain.outbound.jpa.store;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum StoreCategoryType {

    FOOD("food"),
    CLOTH("cloth")
    ;

    private final String typeName;
}
