package csci610.datastore;

import java.util.*;
import java.net.*;
import java.io.*;

/**
 * server class for the database access
 * @author nicka
 */
public class DataStore {

    public static final Map<String, Socket> clientMap = new HashMap<>();
    private static final DatabaseManager dbm = new DatabaseManager();
    
    
    /**
     * main for server, creates a socket, accepts connections from clients, logs users in, queries databases
     * @param args 
     */
    public static void main(String[] args) {
        
        try{
            
            ServerSocket ss = new ServerSocket(5000);
            System.out.println("server started");
            
            while(true){
                Socket cs = ss.accept();
                System.out.println("new client connected: " + cs);
                ClientHandler ch = new ClientHandler(cs);
                ch.start();
            }
            
        } catch (IOException e){
            System.out.println("error in server - Main");
        }
        
    }
    
    
    /**
     * registers an active client, needs to be thread safe
     * 
     * @param user
     * @param s 
     */
    static void regClient(String user, Socket s){
        
        synchronized (clientMap){//ensures only one thread can access the clientMap HashMap at a time
            clientMap.put(user, s);//put the user and socket into the map, this can be used for online user tracking
        }
        
    }
}
    
    class ClientHandler extends Thread {
        
        private final Socket cs;
        private BufferedReader in;
        private static final DatabaseManager dbm = new DatabaseManager();
        
        
        /**
         * client handler constructor, takes a client socket in and creates the 
         * object
         * 
         * @param cs 
         */
        public ClientHandler(Socket cs){
            this.cs = cs;
        }
        
        @Override
        public void run(){
            
           //this is where status codes and user input gathering come from
            
        }
        
        
}

