/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tech.donau.course.service;

import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;
import tech.donau.course.config.RedisConfiguration;
import tech.donau.course.translate.TranslatorService;
import tech.donau.course.util.Base64Value;

import javax.enterprise.context.ApplicationScoped;
import java.util.UUID;

/**
 * @author lucas
 */
@ApplicationScoped
public class GreetingsService {
    private static Logger LOGGER = Logger.getLogger(GreetingsService.class);
    private final String greetingsName;
    private final String greetingsSuffix;
    private final RedisConfiguration redisConfiguration;
    private final Base64Value base64Value;
    private final TranslatorService translatorService;


    public GreetingsService(@ConfigProperty(name = "greetings.name") String greetingsName,
                            @ConfigProperty(name = "greetings.suffix", defaultValue = "Retornei Default pq não inseri a key/value no app.properties") String greetingsSuffix,
                            RedisConfiguration redisConfiguration,
                            @ConfigProperty(name = "greetings.base64name") Base64Value base64Value,
                            TranslatorService translatorService) {
        this.greetingsName = greetingsName;
        this.greetingsSuffix = greetingsSuffix;
        this.redisConfiguration = redisConfiguration;
        this.base64Value = base64Value;
        this.translatorService = translatorService;
    }

    public String getId() {
        LOGGER.info("O que???");
        translatorService.translate();
        return UUID.randomUUID().toString();
    }

    public void propertyWithoutInjection() {
        var value = ConfigProvider.getConfig().getValue("greetings.name", String.class);
    }
}
