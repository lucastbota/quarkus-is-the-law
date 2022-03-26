package tech.donau.course.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import tech.donau.course.entity.Category;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CategoryRepository implements PanacheRepository<Category> {
}
