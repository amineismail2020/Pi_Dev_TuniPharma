/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Karray
 */
public class MyConnection {

   private static final  String driver = "com.mysql.jdbc.Driver";

   private static Connection con;


   private MyConnection(){

   }

   public Connection etablirConnection(){
   try{
       Class.forName("com.mysql.jdbc.Driver");
       con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tunipharma","root","");
             
            System.out.println("Connexion effectué avec succes ...");
   } catch (SQLException ex) {
            Logger.getLogger(ConnectionBase.class.getName()).log(Level.SEVERE, null, ex);
   }   catch (ClassNotFoundException ex) {
           Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);
       }
     return con;   
    }
        
   
   public static Connection getInstance(){
       if (con==null){
           new MyConnection().etablirConnection();
       }
   return con;
   }
}
