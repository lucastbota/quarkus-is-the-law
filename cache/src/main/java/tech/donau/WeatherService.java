package tech.donau;

import io.quarkus.cache.CacheInvalidate;
import io.quarkus.cache.CacheInvalidateAll;
import io.quarkus.cache.CacheKey;
import io.quarkus.cache.CacheResult;
import tech.donau.data.Weather;

import javax.enterprise.context.ApplicationScoped;
import java.util.Random;

@ApplicationScoped
public class WeatherService {

    @CacheResult(cacheName = "weather_status")
    public Weather getBy(@CacheKey String city) {
        return new Weather(city, getStatus());
    }

    @CacheInvalidate(cacheName = "weather_status")
    public void invalidate(String city) {

    }

    @CacheInvalidateAll(cacheName = "weather_status")
    public void invalidateAll() {

    }

    public final String getStatus() {
        try {
            Thread.sleep(5000);
            System.out.println("Sleeping like a rock!!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new Random().nextBoolean() ? "Sunny" : "Rainy";
    }
}
