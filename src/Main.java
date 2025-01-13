import repository.conf.DatabaseConnection;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        final Connection test = DatabaseConnection.getConnection();
    }
}
