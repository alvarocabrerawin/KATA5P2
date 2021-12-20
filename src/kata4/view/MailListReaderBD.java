package kata4.view;
import java.sql.SQLException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kata4.model.Mail;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;



public class MailListReaderBD {
   private static String url = "jdbc:sqlite:C:\\sql\\kata5p1_v2.db";
    
    public static List<Mail> read() throws FileNotFoundException{
        String sql = "SELECT * FROM EMAIL";
        List<Mail> list = new ArrayList<>();
        
        try (   Connection conn = connect();
                Statement statement = conn.createStatement();
                ResultSet rs = statement.executeQuery(sql)){
            while (rs.next()){
                if(!sql.contains("@")){
                    Mail mail = new Mail(rs.getString("direccion"));
                    list.add(mail);
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
    
    public static Connection connect(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Conexión a SQLite establecida");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return conn;
    }
}

