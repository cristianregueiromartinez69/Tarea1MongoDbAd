package controller;

import service.LecturaJsonColecciones;
import service.MongoDbInserccionConJSon;
import service.MongoDbInserccionSinJSon;
import service.Prueba;

import java.util.List;
import java.util.Map;

public class Controller {


    public void logicaPrograma(){
        //MongoDbInserccionSinJSon mongoSinJson = new MongoDbInserccionSinJSon();
        //mongoSinJson.insertarDatosMongoSinJson();
        MongoDbInserccionConJSon mongoJson = new MongoDbInserccionConJSon();

        LecturaJsonColecciones lJson = new LecturaJsonColecciones();
        List<Map<String, Object>> pokemonsList = lJson.readValueObjectsJson("pokemons.json");
        List<Map<String, Object>> adestradorsList = lJson.readValueObjectsJson("adestradores.json");

        mongoJson.insertarDatosConJson(adestradorsList, pokemonsList);

    }
}
