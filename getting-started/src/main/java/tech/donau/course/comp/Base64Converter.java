package tech.donau.course.comp;

import io.vertx.core.cli.converters.Converter;
import tech.donau.course.util.Base64Value;

public class Base64Converter implements Converter<Base64Value> {
    @Override
    public Base64Value fromString(String s) {
        return new Base64Value(s);
    }
}
