package tech.donau.course.converter;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;
import tech.donau.course.dto.Price;

public class PriceDeserializer extends ObjectMapperDeserializer<Price> {

    public PriceDeserializer() {
        super(Price.class);
    }
}
