package tech.donau.course.data;

import org.infinispan.protostream.annotations.ProtoFactory;
import org.infinispan.protostream.annotations.ProtoField;

import java.io.Serializable;
import java.util.Objects;

public class Book implements Serializable {
    private String id;
    private String title;
    private String author;

    public Book() {
    }

    @ProtoFactory
    public Book(String id, String title, String author) {
        this.id = Objects.requireNonNull(id);
        this.title = Objects.requireNonNull(title);
        this.author = Objects.requireNonNull(author);
    }

    @ProtoField(number = 1)
    public String getId() {
        return id;
    }

    @ProtoField(number = 2)
    public String getTitle() {
        return title;
    }

    @ProtoField(number = 3)
    public String getAuthor() {
        return author;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
