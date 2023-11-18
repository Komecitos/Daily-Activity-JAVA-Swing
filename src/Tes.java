import java.sql.*;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.UUID;


public class Tes {
    Connection conn;
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","root");
   
    Statement st = conn.createStatement();
    String query = null;
    ResultSet rs = null;
    
            query = "insert activities (activity_id, activity_name, activity_desc, time_start, time_end, category, user_id, days)\n" +
"value ('2', 'PBOL', 'Kerkom', '11:11:11', '11:11:11', 'tugas', 1, 'senin');";
        st.executeUpdate(query);
    
    
    }
    
    
   
}
