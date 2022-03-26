package tech.donau;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class BookService {
    @Inject
    MongoClient mongoClient;

    public void add(Book book) {
        final MongoCollection<Document> collection = getDocumentMongoCollection();
        var document = new Document();
        document.put("pages", book.pages());
        document.put("title", book.title());

        collection.insertOne(document);
    }

    public List<Book> list() {
        final var result = getDocumentMongoCollection().find();
        final var list = new ArrayList<Book>();
        result.forEach(d -> list.add(Book.from(d)));
        return list;
    }

    private MongoCollection<Document> getDocumentMongoCollection() {
        return mongoClient.getDatabase("bookdb").getCollection("books");
    }
}
