package tech.donau.course;

import org.neo4j.driver.types.Node;

public record Book(String title,
                   Integer pages) {

    public static Book from(Node node) {
        return new Book(node.get("title").asString(), node.get("pages").asInt());
    }
}
