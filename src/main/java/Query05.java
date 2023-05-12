import java.sql.*;

public class Query05 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sql_practice",
                "postgres", "password");

//        //Soru: PreparedStatement kullanarak 105 id li öğrencinin puanını 600 olarak güncelleyiniz
//        PreparedStatement ps1=con.prepareStatement("update ogrenciler set puan=600 where id=105");
//        ps1.executeUpdate();

        //Puan değişkenini parametreli yapalım
//        PreparedStatement ps2=con.prepareStatement("UPDATE ogrenciler SET puan=? WHERE id=?");
//        ps2.setInt(1,600);
//        ps2.setInt(2,102);
//        ps2.executeUpdate();

        //Soru 3 En yüksek puanı alan öğrenciyi getiriniz
        PreparedStatement ps3 = con.prepareStatement("select * from ogrenciler where puan=(select max(puan) from ogrenciler)");
        ResultSet veri = ps3.executeQuery();
        while (veri.next()) {
            System.out.printf("%-6d %-20s %-12s %-6d %-20s\n", veri.getInt("id"), veri.getString("isim"),
                    veri.getString("sehir"), veri.getInt("puan"), veri.getString("bolum"));
        }
    }
}