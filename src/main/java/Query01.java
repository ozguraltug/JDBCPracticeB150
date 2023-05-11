import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class Query01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.Driver Yükleme
        Class.forName("org.postgresql.Driver");

        //2.Bağlantı oluşturma
        Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/sql_practice",
                "postgres","password");
        //3.statement oluştur

        Statement st=con.createStatement();

        //4.Resultset
        ResultSet veri=st.executeQuery("select * from ogrenciler");

        //5.Sonuçları al
        //index olarak
        while(veri.next()){

//            System.out.println(veri.getInt(1)+veri.getString(2)+veri.getString(3)
//            +veri.getInt(4)+veri.getString(5));

            //sütun ismi ile gelsin
//            System.out.println(veri.getInt("id")+veri.getString("isim")+veri.getString("sehir")
//            +veri.getInt("puan")+veri.getString("bolum"));
            System.out.printf("%-6d %-20s %-12s %-6d %-20s\n",veri.getInt("id"),veri.getString("isim"),
                    veri.getString("sehir"),veri.getInt("puan"),veri.getString("bolum"));
       //6.Kapatma
            con.close();
            st.close();
            veri.close();

        }

    }
}
