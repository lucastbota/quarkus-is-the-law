package tech.donau;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class BookService extends AbstractService{
    @Inject
    DynamoDbClient dynamoDB;

    public List<Book> findAll() {
        return dynamoDB.scanPaginator(scanRequest()).items().stream().map(Book::from).collect(Collectors.toList());
    }

    public void add(Book book) {
           dynamoDB.putItem(putRequest(book));
    }

    public Book get(String title) {
        return Book.from(dynamoDB.getItem(getRequest(title)).item());
    }
}
