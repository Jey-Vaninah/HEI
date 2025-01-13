package repository.conf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection;
    private static final String DB_USERNAME = System.getenv("DB_USERNAME");
    private static final String DB_PASSWORD = System.getenv("DB_PASSWORD");
    private static final String DB_URL = System.getenv("DB_URL");

    public static Connection getConnection() {
        if(connection == null) {
            try{
                connection = DriverManager.getConnection(
                        DB_URL,
                        DB_USERNAME,
                        DB_PASSWORD
                );
            }catch (SQLException error){
                throw new RuntimeException("Error occurent when try to connect to database", error);
            }
        }
        return connection;
    }

    public static void closeConnection(){
        if(connection == null){
            return;
        }

      try {
        connection.close();
      } catch (SQLException e) {
        throw new RuntimeException(e);
      }
    }
}
