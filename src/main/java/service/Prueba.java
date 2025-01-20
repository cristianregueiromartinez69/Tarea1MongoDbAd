package service;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import config.MongoDbConnection;
import org.bson.Document;


public class Prueba {

    public void leerDatosMongo() {
        MongoDatabase db = MongoDbConnection.getConnectionMongoDB();

        MongoCollection<Document> collectionAdestradores = db.getCollection("adestradores");
        MongoCollection<Document> collectionPokemons = db.getCollection("pokemons");

        System.out.println("Adestradores: ");

        FindIterable<Document> iterableAdestradores = collectionAdestradores.find();

        for(Document doc : iterableAdestradores) {
            System.out.println(doc.toJson());
        }

        System.out.println("\nPokemons: ");

        FindIterable<Document> iterablePokemons = collectionPokemons.find();

        for(Document doc : iterablePokemons) {
            System.out.println(doc.toJson());
        }


    }

}
