import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Query04 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sql_practice",
                "postgres", "password");
        Statement st1 = con.createStatement();

        //Soru : Öğrenciler tablosuna yani bir öğrenci ekleyin
        //(109,'Ömer Seyfettin','Ankara',550,'Yazar')

//        int sayi= st1.executeUpdate("insert into ogrenciler values(109,'Ömer Seyfettin','Ankara',550,'Yazar')");
//
//        System.out.println(sayi+ " veri güncellendi");

        //Soru : Öğrenciler tablosuna birden fazla veri ekleyin
        //(110,'Ahmet Hamdi Tanpınar','Ankara',550,'Yazar'),
        // (111,'Kemal Tahir','Ankara',550,'Yazar'),
        // (112,'Cahit Sıtkı Tarancı','Ankara',550,'Yazar')

        String [] veri={"insert into ogrenciler values(110,'Ahmet Hamdi Tanpınar','Ankara',550,'Yazar')",
                "insert into ogrenciler values (111,'Kemal Tahir','Ankara',550,'Yazar')",
                "insert into ogrenciler values (112,'Cahit Sıtkı Tarancı','Ankara',550,'Yazar')"};
        int count=0;
        for(String each:veri){
            count+= st1.executeUpdate(each);
        }
        System.out.println(count+" adet veri güncellendi");

        con.close();
        st1.close();
    }
}
