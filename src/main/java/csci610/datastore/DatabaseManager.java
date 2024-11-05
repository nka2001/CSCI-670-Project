package csci610.datastore;

import java.sql.*;


/**
 *
 * @author nicka
 */
public class DatabaseManager {
    
    public static Connection c;
    
    public static void connect(){
        try{
           //Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/InventoryManagement","root","Som3timesth1ngsn$$dtobeChanged");
            
        } catch(Exception e){
            System.out.println("error in static void connect");
            e.printStackTrace();
        }
    }
    
    
    public DatabaseManager(){
        
    }
    
    public boolean init_ConnectionToDB(String username, String password){
        
        return false;
    }
    
}
