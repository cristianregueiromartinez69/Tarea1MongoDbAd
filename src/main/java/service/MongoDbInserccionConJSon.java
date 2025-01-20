package service;


import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import config.MongoDbConnection;
import org.bson.Document;

import java.util.List;
import java.util.Map;

/**
 * Clase para realizar insercciones desde un archivo Json
 * @author cristian
 * @version 1.0
 */
public class MongoDbInserccionConJSon {

    /**
     * Metodo para insertar los datos en la base de mongo desde un archivo json
     * @param adestradoresList la lista de adestradores
     * @param pokemonsList la lista de pokemons
     */
    public void insertarDatosConJson(List<Map<String, Object>> adestradoresList, List<Map<String, Object>> pokemonsList){

        //nos conectamos a la base de mongo db llamando al metodo de configuracion de mongo
        MongoDatabase mongoDatabase = MongoDbConnection.getConnectionMongoDB();

        //obtenemos las colecciones de la base, si no las hay, las crea automaticamente
        MongoCollection<Document> collectionAdestradores = mongoDatabase.getCollection("adestradores");
        MongoCollection<Document> collectionPokemons = mongoDatabase.getCollection("pokemons");

        /**
         * Con un for, recorremos la lista de los json de pokemon y adestradores
         * los metemos en mongo con el metodo insertOne
         */
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
