package tech.donau.course.config;

import org.hibernate.search.backend.elasticsearch.analysis.ElasticsearchAnalysisConfigurationContext;
import org.hibernate.search.backend.elasticsearch.analysis.ElasticsearchAnalysisConfigurer;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Dependent
@Named("elastichConfiguration")
public class ElastichConfiguration implements ElasticsearchAnalysisConfigurer {
    @Override
    public void configure(ElasticsearchAnalysisConfigurationContext configurationContext) {
        configurationContext.analyzer("name").custom()
                .tokenizer("standard")
                .tokenFilters("asciifolding", "uppercase");

        configurationContext.analyzer("english").custom()
                .tokenizer("standard")
                .tokenFilters("asciifolding", "uppercase", "porter_stem");

        configurationContext.normalizer("sort").custom() .tokenFilters("asciifolding", "uppercase");
    }
}
