
package GUI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionDB {
    
    Stack<Integer> act = new Stack<Integer>();
    Activities a = new Activities();
    
    public Connection getConnection(){
        Connection conn = null;
                
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "root");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
               
        return conn;
    }
    
    public void insertUsers() throws SQLException{
        Connection conn = this.getConnection();
        String query = "";
        
        Statement stmt = conn.createStatement();
        query = "Insert users (username, first_name, last_name, email, password)"
                + "Value ('"+a.getName()+"', ";
        stmt.executeUpdate(query);
        
        
        
    }
    public void insertActivities() throws SQLException{
        Connection conn = this.getConnection();
        String query = "";
        
        Statement stmt = conn.createStatement();
        query = "Insert activities (activity_name, activity_desc, time_start, time_end, category, days, user_id)"
                + "Value ('"+a.getName()+"', '"+a.getDesc()+"', '"+a.getTimeS()+"', '"+a.getTimeE()+"', '"+a.getCat()+"', '"+a.getDays()+"', '"+a.getUser_id()+"' ";
        stmt.executeUpdate(query);
        
        
        
    }
    public String getAct(){
        
        return a.getName();
    }
    
}
