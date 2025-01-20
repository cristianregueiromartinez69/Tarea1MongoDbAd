package service;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Clase para leer un archivo Json para introducirlo en mongo
 * @author cristian
 * @version 1.0
 */
public class LecturaJsonColecciones {

    /**
     * Metodo que lee un archivo json
     * @param path el path del archivo
     * @return una lista que tiene un hashmap con una clave que e sun string y un valor que es un objeto
     */
    public List<Map<String, Object>> readValueObjectsJson(String path){
        ObjectMapper mapper = new ObjectMapper();
        try{
            return mapper.readValue(new File(path), mapper.getTypeFactory().constructCollectionType(List.class, Map.class));
        } catch (IOException e) {
            System.out.println("Ups, error al leer el achivo json");
        }
        return null;
    }


}
