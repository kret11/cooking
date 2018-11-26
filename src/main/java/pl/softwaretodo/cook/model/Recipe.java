package pl.softwaretodo.cook.model;

import java.util.List;
import org.bson.types.ObjectId;

public class Recipe {

  private ObjectId id;
  private String ownerId;
  private String name;
  private List<String> products;
  private String description;
  private List<String> sharedTo;

  public ObjectId getId() {
    return id;
  }

  public void setId(ObjectId id) {
    this.id = id;
  }

  public String getOwnerId() {
    return ownerId;
  }

  public void setOwnerId(String ownerId) {
    this.ownerId = ownerId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<String> getProducts() {
    return products;
  }

  public void setProducts(List<String> products) {
    this.products = products;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<String> getSharedTo() {
    return sharedTo;
  }

  public void setSharedTo(List<String> sharedTo) {
    this.sharedTo = sharedTo;
  }

}
