package tech.donau.course.util;

import java.util.Base64;

public class Base64Value {
    private String value;

    public Base64Value(String base64Value) {
        this.value = new String(Base64.getDecoder().decode(base64Value));
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Base64Converter{" +
                "value='" + value + '\'' +
                '}';
    }
}
