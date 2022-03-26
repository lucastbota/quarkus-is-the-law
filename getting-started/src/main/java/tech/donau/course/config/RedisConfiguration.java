package tech.donau.course.config;

import io.smallrye.config.ConfigMapping;

@ConfigMapping(prefix = "remote")
public interface RedisConfiguration {
    String container();
    String vpc();
}
