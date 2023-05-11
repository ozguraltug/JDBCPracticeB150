import java.sql.*;

public class Query02 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {


// 1.Driver yükleme
     Class.forName("org.postgresql.Driver");

        //2.Bağlantı oluşturma

        Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/sql_practice",
                "postgres","password");
        //3.statement oluştur

        Statement st1= con.createStatement();

        //Soru: Öğrenciler tablosundaki şehri İzmir olanları listeleyiniz

//        ResultSet veri= st1.executeQuery("SELECT * FROM ogrenciler WHERE sehir='İzmir'");
//while(veri.next()) {
//    System.out.printf("%-6d %-20s %-12s %-6d %-20s\n", veri.getInt("id"), veri.getString("isim"),
//            veri.getString("sehir"), veri.getInt("puan"), veri.getString("bolum"));
//}
//Soru :Öğrenciler tablosundan puanı 500 üzerinde olanları getiriniz
//Statement st2=con.createStatement();
//ResultSet veri2=st1.executeQuery("select * from ogrenciler where puan>500");
//        while(veri2.next()) {
//            System.out.printf("%-6d %-20s %-12s %-6d %-20s\n", veri2.getInt("id"), veri2.getString("isim"),
//                    veri2.getString("sehir"), veri2.getInt("puan"), veri2.getString("bolum"));
//        }
// Soru :Öğrenciler tablosundan id si 103 ile 106 arasında olanları getiriniz
    Statement st3=con.createStatement();
        ResultSet veri3=st3.executeQuery("select * from ogrenciler where id between 103 and 106");
        while(veri3.next()) {
            System.out.printf("%-6d %-20s %-12s %-6d %-20s\n", veri3.getInt("id"), veri3.getString("isim"),
                    veri3.getString("sehir"), veri3.getInt("puan"), veri3.getString("bolum"));
        }

        con.close();
        st1.close();
        // st2.close();
        st3.close();
        veri3.close();
//veri.close();
//veri2.close();
    }
}
