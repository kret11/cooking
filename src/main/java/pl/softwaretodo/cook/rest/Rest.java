package pl.softwaretodo.cook.rest;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import pl.softwaretodo.cook.dao.RecipeService;
import pl.softwaretodo.cook.model.Recipe;

@Path("/")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@RequestScoped
public class Rest {

  @Inject
  RecipeService rr;

  @GET
  @Path("/recipes")
  public List<Recipe> search(@QueryParam("products") List<String> products) {
    return rr.findByProducts(products);
  }

}
