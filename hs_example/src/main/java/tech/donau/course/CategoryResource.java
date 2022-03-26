package tech.donau.course;

import io.quarkus.runtime.StartupEvent;
import org.hibernate.search.mapper.orm.session.SearchSession;
import tech.donau.course.entity.Category;
import tech.donau.course.repository.CategoryRepository;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@Path("/category")
public class CategoryResource {
    @Inject
    private CategoryRepository categoryRepository;
    @Inject
    private SearchSession session;

    @Transactional
    public void onStart(@Observes StartupEvent startupEvent) throws InterruptedException {
        if (categoryRepository.count() > 0) {
            session.massIndexer().startAndWait();
        }
    }

    @Path("/find")
    @GET
    public List<Category> findAll() {
        return categoryRepository.findAll().stream().toList();
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public String create(Category category) {
        categoryRepository.persist(category);
        return String.format("%s - %s", category.getId(), category.getDescription());
    }

    @Path("/search")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public List<Category> search(@QueryParam("pattern") String pattern, @QueryParam("size") Optional<Integer> size) {
return        session
                .search(Category.class).where(w -> pattern == null || pattern.isBlank() ?
                        w.matchAll() : w.simpleQueryString().fields("name", "description").matching(pattern))
                .sort(s -> s.field("categoryName_sort").then().field("categoryDescription_sort"))
        .fetch(size.orElse(20))
                 .hits();
    }
}
