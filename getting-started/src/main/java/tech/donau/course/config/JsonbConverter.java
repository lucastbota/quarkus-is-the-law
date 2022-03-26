package tech.donau.course.config;

import io.quarkus.jsonb.JsonbConfigCustomizer;

import javax.json.bind.JsonbConfig;

public class JsonbConverter implements JsonbConfigCustomizer {
    @Override
    public void customize(JsonbConfig jsonbConfig) {
        //caso queria configurar, tipo o jackson
    }
}
