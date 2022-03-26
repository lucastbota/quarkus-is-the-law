package tech.donau;


import io.quarkus.runtime.annotations.RegisterForReflection;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import java.util.Map;

@RegisterForReflection
public record Book(String title, Integer pages) {
    public static String TABLE_NAME = "Books";
    public static String BOOK_NAME_COLUMN = "title";
    public static String BOOK_PAGES_COLUMN = "pages";

    public static Book from(Map<String, AttributeValue> item) {
        return new Book(item.get(BOOK_NAME_COLUMN).s(), Integer.valueOf(item.get(BOOK_PAGES_COLUMN).s()));
    }
}
