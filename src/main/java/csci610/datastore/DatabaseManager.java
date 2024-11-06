package csci610.datastore;

import java.sql.*;

/**
 *
 * @author nicka
 */
public class DatabaseManager {

    public static Connection c;

    public static void connect() {
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/InventoryManagement", "root", "Som3timesth1ngsn$$dtobeChanged");

        } catch (Exception e) {
            System.out.println("error in static void connect");
            e.printStackTrace();
        }
    }

    public DatabaseManager() {

    }

    public boolean init_ConnectionToDB(String username, String password) {
        return init_ConnectToDB(username, password);
    }

    private boolean init_ConnectToDB(String username, String password) {

        try {
            PreparedStatement ps = c.prepareStatement("Select username, User_password, Disabled from users where username = ?");
            ps.setString(1, username.trim());
            
            ResultSet rs = ps.executeQuery();
            
            if(!rs.next()){
                return false;
            } else {
                
                String encryptedPass = rs.getString("User_password");
                boolean isDisabled = rs.getBoolean("Disabled");
                System.out.println("Encrypted Password: " + encryptedPass);
                System.out.println(isDisabled);
                
                String encryptUserInput = EncryptionManager.encrypt(password);
                
                if(encryptUserInput.equals(encryptedPass) && !isDisabled){
                    System.out.println("good password");
                    return true;
                }
                
                
                
            }
            
            
            
        } catch(SQLException e){
            System.out.println("error in initconnecttoDB");
            e.printStackTrace();
        }
            return false;
        }

    }
