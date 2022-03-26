package tech.donau;

import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;
import software.amazon.awssdk.services.dynamodb.model.ScanRequest;

import javax.enterprise.context.ApplicationScoped;
import java.util.Map;

public abstract class AbstractService {
    protected ScanRequest scanRequest() {
        return ScanRequest.builder().tableName(Book.TABLE_NAME).attributesToGet(Book.BOOK_NAME_COLUMN, Book.BOOK_PAGES_COLUMN)
                .build();
    }

    protected PutItemRequest putRequest(Book book) {
        Map<String, AttributeValue> item = Map.of(Book.BOOK_NAME_COLUMN, AttributeValue.builder().s(book.title()).build(),
                Book.BOOK_PAGES_COLUMN, AttributeValue.builder().s(book.pages().toString()).build());
        return PutItemRequest.builder()
                .tableName(Book.TABLE_NAME)
                .item(item)
                .build();
    }

    protected GetItemRequest getRequest(String title) {
        var key = Map.of(Book.BOOK_NAME_COLUMN, AttributeValue.builder().s(title).build());

        return GetItemRequest.builder().tableName(Book.TABLE_NAME).key(key).attributesToGet(Book.BOOK_NAME_COLUMN, Book.BOOK_PAGES_COLUMN).build();
    }
}
