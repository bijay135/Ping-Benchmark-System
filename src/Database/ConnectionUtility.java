package Database;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtility {
    private static Connection connection;
    public static Connection getConnection() throws Exception {
        if (connection == null) {
            connection = DriverManager.getConnection("jdbc:h2:./db/history;schema=ping_benchmark_system");
        }
            return connection;
    }
	
    public static void closeConnection() throws Exception {
        if(connection!=null) {
            connection.close();
            connection = null;
        }
    }
}
