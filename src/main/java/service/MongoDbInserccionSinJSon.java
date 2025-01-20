package service;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import config.MongoDbConnection;
import org.bson.Document;
import org.bson.types.ObjectId;
import java.util.Arrays;
import java.util.List;


public class MongoDbInserccionSinJSon {

    public void insertarDatosMongoSinJson(){
        MongoDatabase mongoDatabase = MongoDbConnection.getConnectionMongoDB();
        MongoCollection<Document> collectionAdestrador = mongoDatabase.getCollection("adestradores");
        MongoCollection<Document> collectionPokemon = mongoDatabase.getCollection("pokemons");

        Document adestradorDocument = new Document()
                .append("nome", "Ash mostaza")
                .append("idade", 10)
                .append("cidade", "pueblo paleta");

        collectionAdestrador.insertOne(adestradorDocument);

        System.out.println("Datos insertados correctamente de adestradores  en mongo db");


        ObjectId idAdestrador = adestradorDocument.getObjectId("_id");

        Document pokemonDocument = new Document()
                .append("nome", "tinkaton")
                .append("tipo", List.of("hada", "acero"))
                .append("nivel", 100)
                .append("habilidades", List.of("rompemoldes", "ritmo propio", "hurto"))
                .append("id_adestrador", idAdestrador);

        collectionPokemon.insertOne(pokemonDocument);
        System.out.println("Datos insertados correctamente de pokemons  en mongo db");

    }
}
