package service;


import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import config.MongoDbConnection;
import org.bson.Document;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MongoDbInserccionConJSon {

    public void insertarDatosConJson(List<Map<String, Object>> adestradoresList, List<Map<String, Object>> pokemonsList){

        MongoDatabase mongoDatabase = MongoDbConnection.getConnectionMongoDB();

        MongoCollection<Document> collectionAdestradores = mongoDatabase.getCollection("adestradores");
        MongoCollection<Document> collectionPokemons = mongoDatabase.getCollection("pokemons");

        for(Map<String, Object> adestrador : adestradoresList){
            Document adestradorDoc = new Document(adestrador);
            collectionAdestradores.insertOne(adestradorDoc);
        }
        System.out.println("Documento de adestrador escrito correctamente desde Json");

        for(Map<String, Object> pokemon : pokemonsList){
            Document pokemonDoc = new Document(pokemon);
            collectionPokemons.insertOne(pokemonDoc);
        }

        System.out.println("Documento de pokemon escrito correctamente desde Json");
    }

}
