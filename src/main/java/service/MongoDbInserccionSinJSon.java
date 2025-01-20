package service;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import config.MongoDbConnection;
import org.bson.Document;
import org.bson.types.ObjectId;
import java.util.Arrays;
import java.util.List;

/**
 * Clase para realizar insercciones en la base de datos de mongo sin json
 * @author cristian
 * @version 1.0
 */
public class MongoDbInserccionSinJSon {

    /**
     * Metodo que realiza la inserccion de 2 maneras
     * 1. solo 1 inserccion
     * 2. muchas insercciones
     */
    public void insertarDatosMongoSinJson(){

        /*
          Realizando solo 1 inserccion
         */


        /*
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
         */

        /*
          Realizando varias insercciones
         */

        MongoDatabase mongoDatabase = MongoDbConnection.getConnectionMongoDB();
        MongoCollection<Document> collectionAdestrador = mongoDatabase.getCollection("adestradores");
        MongoCollection<Document> collectionPokemon = mongoDatabase.getCollection("pokemons");


        /*
         * El procedimiento es el mismo para las 2 colecciones:
         * 1. creamos un List que va a ser de tipo Document y vamos creando documentos con los datos a meter
         * 2. una vez acabado, llamamos al metodo insertMany y se realiza la inserccion
         */

        List<Document> documentAdestrador = Arrays.asList(
                new Document().append("nome", "Ash mostaza").append("idade", 10).append("cidade", "pueblo paleta"),
                new Document().append("nome", "liko").append("idade", 14).append("cidade", "pueblo altamia"),
                new Document().append("nome", "polo").append("idade", 13).append("cidade", "ciudad rocavelo"),
                new Document().append("nome", "tobías").append("idade", 18).append("cidade", "ciudad carmín")

        );

        collectionAdestrador.insertMany(documentAdestrador);

        System.out.println("Muchos datos insertados en la coleccion de adestradores");

        Document ashDocument = collectionAdestrador.find().first();
        assert ashDocument != null;
        ObjectId id = ashDocument.getObjectId("_id");

        List<Document> documentPokemon = Arrays.asList(
                new Document().append("nome", "tinkaton").append("tipo", List.of("hada", "acero")).append("nivel", 100).append("habilidades", List.of("rompemoldes", "ritmo propio", "hurto")).append("id_adestrador", id),
                new Document().append("nome", "pikachu").append("tipo", List.of("electrico")).append("nivel", 50).append("habilidades", List.of("electricidad estática", "pararrayos")).append("id_adestrador", id),
                new Document().append("nome", "gengar").append("tipo", List.of("fantasma", "veneno")).append("nivel", 98).append("habilidades", List.of("levitación", "cuerpo maldito")).append("id_adestrador", id)

        );

        collectionPokemon.insertMany(documentPokemon);
        System.out.println("Muchos datos insertados en la coleccion de pokemons");

    }
}
