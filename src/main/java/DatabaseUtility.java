import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtility {

    private static Connection connection;
    public static Connection createConnection() throws SQLException {
        String url="jdbc:postgresql://localhost:5432/sql_practice";
        String user="postgres";
        String password="password";

        try {
            connection=DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
