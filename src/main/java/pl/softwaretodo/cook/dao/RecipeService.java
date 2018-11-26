package pl.softwaretodo.cook.dao;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import pl.softwaretodo.cook.model.Recipe;

@Stateless
public class RecipeService {

  @Inject
  MongoDatabase database;

  public List<Recipe> findByProducts(List<String> products) {
    MongoCollection<Recipe> collection = database.getCollection("recipes", Recipe.class);
    FindIterable<Recipe> result = collection.find(Filters.all("products", products));
    return result.into(new ArrayList<>());
  }

  public void save(Recipe r) {
    MongoCollection<Recipe> collection = database.getCollection("recipes", Recipe.class);
    collection.insertOne(r);
  }

  public void clearCollection() {
    MongoCollection<Recipe> collection = database.getCollection("recipes", Recipe.class);
    collection.drop();
  }


}
