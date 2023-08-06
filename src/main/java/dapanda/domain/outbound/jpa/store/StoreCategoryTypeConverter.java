package dapanda.domain.outbound.jpa.store;

import dapanda.domain.outbound.jpa.store.categoryenum.StoreCategoryType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.EnumSet;
import java.util.NoSuchElementException;

@Converter(autoApply = true)
public class StoreCategoryTypeConverter implements AttributeConverter<StoreCategoryType, String> {
    @Override
    public String convertToDatabaseColumn(StoreCategoryType attribute) {
        return attribute.getTypeName();
    }

    @Override
    public StoreCategoryType convertToEntityAttribute(String dbData) {
        return EnumSet.allOf(StoreCategoryType.class).stream()
                .filter(e -> e.getTypeName().equals(dbData))
                .findFirst()
                .orElseThrow(()-> new NoSuchElementException("aaa"));
    }
}
