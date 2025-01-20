package controller;

import service.LecturaJsonColecciones;
import service.MongoDbInserccionConJSon;
import service.MongoDbInserccionSinJSon;

import java.util.List;
import java.util.Map;

/**
 * Clase controller con la lógica de la aplicación
 * @author cristian
 * @version 1.0
 */
public class Controller {


    /**
     * Metodo principal que crea objetos de las diferentes clases que realizan las insercciones en la base de mongo db
     */
    public void logicaPrograma(){

        /*
        Metodos realizando 1 inserccion
         */
        MongoDbInserccionSinJSon mongoSinJson = new MongoDbInserccionSinJSon();
        MongoDbInserccionConJSon mongoJson = new MongoDbInserccionConJSon();

        LecturaJsonColecciones lJson = new LecturaJsonColecciones();
        //mongoSinJson.insertarDatosMongoSinJson();

        /*
        MongoDbInserccionConJSon mongoJson = new MongoDbInserccionConJSon();
        List<Map<String, Object>> pokemonsList = lJson.readValueObjectsJson("pokemons.json");
        List<Map<String, Object>> adestradorsList = lJson.readValueObjectsJson("adestradores.json");

        mongoJson.insertarDatosConJson(adestradorsList, pokemonsList);
         */

        /*
        Metodos realizando muchas insercciones
         */

        mongoSinJson.insertarDatosMongoSinJson();
        List<Map<String, Object>> pokemonsList = lJson.readValueObjectsJson("pokemons.json");
        List<Map<String, Object>> adestradorsList = lJson.readValueObjectsJson("adestradores.json");

        mongoJson.insertarDatosConJson(adestradorsList, pokemonsList);
    }
}
