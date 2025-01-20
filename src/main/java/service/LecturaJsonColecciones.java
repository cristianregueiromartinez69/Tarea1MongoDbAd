package service;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class LecturaJsonColecciones {

    public List<Map<String, Object>> readValuePokemonsJson(){
        ObjectMapper mapper = new ObjectMapper();
        try{
            return mapper.readValue(new File("pokemons.json"), mapper.getTypeFactory().constructCollectionType(List.class, Map.class));
        } catch (IOException e) {
            System.out.println("Ups, error al leer el json de pokemnons");
        }
        return null;
    }

    public Object readValueAdestradores(){
        ObjectMapper mapper = new ObjectMapper();

        try{
            return mapper.readValue(new File("adestradores.json"), Object.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
