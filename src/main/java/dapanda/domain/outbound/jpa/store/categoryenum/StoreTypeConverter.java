package dapanda.domain.outbound.jpa.store.categoryenum;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.EnumSet;
import java.util.NoSuchElementException;

@Converter
public class StoreTypeConverter implements AttributeConverter<StoreCategoryType, String> {

    @Override
    public String convertToDatabaseColumn(StoreCategoryType attribute) {
        return attribute.getTypeName();
    }

    @Override
    public StoreCategoryType convertToEntityAttribute(String dbData) {
        return EnumSet.allOf(StoreCategoryType.class).stream()
                .filter(e -> e.getTypeName().equals(dbData))
                .findAny()
                .orElseThrow(()-> new NoSuchElementException("aa"));
    }
}
