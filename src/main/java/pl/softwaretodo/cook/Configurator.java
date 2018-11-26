package pl.softwaretodo.cook;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.inject.Produces;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

@Singleton
@Startup
public class Configurator {

  private MongoDatabase database;

  @PostConstruct
  public void init() {
    CodecRegistry pojoCodecRegistry = CodecRegistries
        .fromRegistries(
            MongoClientSettings.getDefaultCodecRegistry(),
            CodecRegistries.fromProviders(
                PojoCodecProvider.builder().automatic(true).build()));

    MongoClientSettings settings =
        MongoClientSettings.builder().codecRegistry(pojoCodecRegistry).build();
    MongoClient mongoClient = MongoClients.create(settings);
    database = mongoClient.getDatabase("mydb");
  }

  @Produces
  public MongoDatabase produceDatabaseHandler() {
    return database;
  }
}
