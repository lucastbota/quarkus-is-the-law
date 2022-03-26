package tech.donau;

import org.bson.Document;

public record Book (String title, Integer pages) {
    public static Book from(Document d) {
        return new Book(d.getString("title"), d.getInteger("pages"));
    }
}
