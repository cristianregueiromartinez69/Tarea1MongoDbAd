package controller;

import service.MongoDbInserccionSinJSon;
import service.Prueba;

public class Controller {


    public void logicaPrograma(){
        MongoDbInserccionSinJSon mongoSinJson = new MongoDbInserccionSinJSon();
        mongoSinJson.insertarDatosMongoSinJson();

        Prueba pruebaLectura = new Prueba();
        pruebaLectura.leerDatosMongo();
    }
}
