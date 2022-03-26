package tech.donau.course.entity;

import org.hibernate.search.engine.backend.types.Sortable;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.KeywordField;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Indexed
public class Category {
    @Id
    private Long id;
    @FullTextField(analyzer = "name")
    @KeywordField(name = "categoryName_sort", sortable = Sortable.YES, normalizer = "sort")
    private String name;

    @FullTextField(analyzer = "name")
    @KeywordField(name = "categoryDescription_sort", sortable = Sortable.YES, normalizer = "sort")
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
