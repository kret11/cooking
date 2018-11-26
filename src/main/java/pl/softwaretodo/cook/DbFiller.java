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
  RecipeService service;

  @PostConstruct
  public void run() {
    if (SAMPLE_RECIPES) {
      insertSampleRecipes();
    }
  }

  private void insertSampleRecipes() {
    service.clearCollection();

    Recipe r = new Recipe();
    r.setName("Bigos");
    r.setProducts(new ArrayList<>());
    r.getProducts().add("Kapusta");
    r.getProducts().add("Mięso");
    r.setOwnerId("1454497121344050");
    r.setDescription("Pokrój kapustę. Wymieszaj.");
    service.save(r);

    r = new Recipe();
    r.setName("Gołąbki");
    r.setProducts(new ArrayList<>());
    r.getProducts().add("Kapusta");
    r.getProducts().add("Mięso");
    r.getProducts().add("Ryż");
    r.setOwnerId("1454497121344050");
    r.setDescription("Wymieszaj mięso mielone z ryżem. Zawiń w kapustę.");
    service.save(r);

    r = new Recipe();
    r.setName("Surówka");
    r.setProducts(new ArrayList<>());
    r.getProducts().add("Kapusta");
    r.getProducts().add("Marchewka");
    r.setOwnerId("1454497121344050");
    r.setDescription("Pokrój i wymieszaj.");
    service.save(r);
  }

}
