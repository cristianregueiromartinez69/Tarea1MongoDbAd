package controller;

import service.LecturaJsonColecciones;
import service.MongoDbInserccionSinJSon;
import service.Prueba;

import java.util.List;
import java.util.Map;

public class Controller {


    public void logicaPrograma(){
        //MongoDbInserccionSinJSon mongoSinJson = new MongoDbInserccionSinJSon();
        //mongoSinJson.insertarDatosMongoSinJson();
        LecturaJsonColecciones lJson = new LecturaJsonColecciones();
        List<Map<String, Object>> adestradorList = lJson.readValueAdestradores();
    }
}
