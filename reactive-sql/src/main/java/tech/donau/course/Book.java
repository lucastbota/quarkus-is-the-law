package tech.donau.course;

import io.vertx.mutiny.sqlclient.Row;

public record Book (Integer id, String title) {
    public static Book from(Row row) {
        return new Book(row.getInteger("id"), row.getString("title"));
    }
}
