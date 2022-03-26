package tech.donau.course.data;

import java.io.Serializable;

public class Book implements Serializable {
    private final String id;
    private final String description;
    private final String author;

    public Book(String id, String description, String author) {
        this.id = id;
        this.description = description;
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getAuthor() {
        return author;
    }
}
