package config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoDbConnection {

    private static final String connectionMongoDb = "mongodb+srv://mongo:mongo@proyectoad.xgtsf.mongodb.net/?retryWrites=true&w=majority&appName=ProyectoAD";
    private static final String databaseName = "dbpokemons";

    public static MongoDatabase getConnectionMongoDB(){
        MongoClient mongoClient = MongoClients.create(connectionMongoDb);
            System.out.println("Conexion exitosa con la base de datos de mongo db");
            return mongoClient.getDatabase(databaseName);

    }

}
