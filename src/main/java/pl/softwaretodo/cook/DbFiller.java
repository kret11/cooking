package pl.softwaretodo.cook;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.DependsOn;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import pl.softwaretodo.cook.dao.RecipeService;
import pl.softwaretodo.cook.model.Recipe;

@Singleton
@Startup
@DependsOn(value = "Configurator")
public class DbFiller {

  private static final boolean SAMPLE_RECIPES = true;

  @Inject
  RecipeService rr;

  @PostConstruct
  public void run() {
    if (SAMPLE_RECIPES) {
      insertSampleRecipes();
    }
  }

  private void insertSampleRecipes() {
    Recipe r = new Recipe();
    r.setName("Bigos");
    r.setProducts(new ArrayList<>());
    r.getProducts().add("Kapusta");
    r.getProducts().add("Mięso");
    r.setOwnerId("1454497121344050");
    rr.save(r);

    r = new Recipe();
    r.setName("Gołąbki");
    r.setProducts(new ArrayList<>());
    r.getProducts().add("Kapusta");
    r.getProducts().add("Mięso");
    r.getProducts().add("Ryż");
    r.setOwnerId("1454497121344050");
    rr.save(r);

    r = new Recipe();
    r.setName("Surówka");
    r.setProducts(new ArrayList<>());
    r.getProducts().add("Kapusta");
    r.getProducts().add("Marchewka");
    r.setOwnerId("1454497121344050");
    rr.save(r);
  }

}
