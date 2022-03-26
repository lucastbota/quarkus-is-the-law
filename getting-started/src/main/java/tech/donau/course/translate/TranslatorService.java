package tech.donau.course.translate;

import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TranslatorService {
    private static final Logger LOGGER = Logger.getLogger(TranslatorService.class.getName());

    private RawService rawService;

    public TranslatorService(RawService rawService) {
        this.rawService = rawService;
    }

    public void translate() {
        LOGGER.info("TRANSLATOR");

        LOGGER.info(rawService.getRawData());
    }
}
