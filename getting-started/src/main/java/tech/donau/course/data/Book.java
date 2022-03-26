package tech.donau.course.data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Objects;

public class Book implements Serializable {
    private final Long id;
    @NotBlank(message = "Book's name cannot be blank")
    private final String name;
    private final String author;

    public Book() {
        this.id = null;
        this.name = null;
        this.author = null;
    }

    public Book(Long id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id.equals(book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
