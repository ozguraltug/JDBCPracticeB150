import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Transaction {
    public static void main(String[] args) throws SQLException {


        Connection con = DriverManager.getConnection
                ("jdbc:postgresql://localhost:5432/sql_practice", "postgres", "password");

        con.setAutoCommit(false);
        try {
            PreparedStatement ps1 = con.prepareStatement
                    ("CREATE TABLE if not exists mezunOgrenciler " +
                            "(id int,isim varchar(50),sehir varchar(50),puan int,bolum varchar(20))");

            PreparedStatement ps2 = con.prepareStatement("INSERT INTO mezunOgrenciler VALUES" +
                    "(100, 'Ahmet Ümit', 'İstanbul', 546, 'Bilgisayar Müh.')");

            PreparedStatement ps3 = con.prepareStatement
                    ("delete from ogrenciler where isim='Ahmet Ümit'");

            ps1.executeUpdate();
            ps2.executeUpdate();
            ps3.executeUpdate();

            con.commit();
            ps1.close();
            ps2.close();
            ps3.close();
            con.close();
        } catch (Exception e) {
            con.rollback();
            System.out.println(e.getMessage());
        }

    }
}
