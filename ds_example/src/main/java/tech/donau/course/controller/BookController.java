package tech.donau.course.controller;

import io.agroal.api.AgroalDataSource;
import io.quarkus.agroal.DataSource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;

@Path("/book")
public class BookController {

    private final AgroalDataSource userDataSource;
    private final AgroalDataSource productDataSource;

    public BookController(@DataSource("users") AgroalDataSource userDataSource, @DataSource("product") AgroalDataSource productDataSource) {
        this.userDataSource = userDataSource;
        this.productDataSource = productDataSource;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String get() throws SQLException {
        userDataSource.getConnection().prepareStatement("SELECT 1").execute();
        productDataSource.getConnection().prepareStatement("SELECT 1").execute();
        return "<h1>Fear or Wrath</h1>";
    }
}
