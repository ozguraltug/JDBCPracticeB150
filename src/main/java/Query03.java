import org.postgresql.util.PGPropertyMaxResultBufferParser;

import java.sql.*;

public class Query03 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sql_practice",
                "postgres", "password");
       // Statement st1 = con.createStatement();
        PreparedStatement ps=con.prepareStatement("insert into ogrenciler values(?,?,?,?,?)");
        ps.setInt(1,108);
        ps.setString(2,"Yakup Kadri Karaosmanoğlu");
        ps.setString(3,"İstanbul");
        ps.setInt(4,500);
        ps.setString(5,"Edebiyat");

        int veriSayisi=ps.executeUpdate();
        System.out.println(veriSayisi+ " adet veri güncellendi");

        con.close();
        ps.close();
    }
}
