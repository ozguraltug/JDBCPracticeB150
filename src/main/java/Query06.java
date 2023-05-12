import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Query06 {
    public static void main(String[] args) throws SQLException {
        Connection con=DatabaseUtility.createConnection();
        Statement st=con.createStatement();
        ResultSet veri=st.executeQuery("select * from ogrenciler");
        while (veri.next()) {


            System.out.printf("%-6d %-20s %-12s %-6d %-20s\n", veri.getInt("id"), veri.getString("isim"), veri.getString("sehir"), veri.getInt("puan"), veri.getString("bolum"));

        }

    }
}
