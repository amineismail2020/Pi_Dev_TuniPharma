/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Connection;


import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SAMSUNG
 */
public class ConnectionBase {
    private static ConnectionBase instance=null;
    private static java.sql.Connection connection=null;
    
  
    private ConnectionBase(){
     
  if(connection==null){
      try {
           Class.forName("com.mysql.jdbc.Driver");
           
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionBase.class.getName()).log(Level.SEVERE, null, ex);
        }
      
      try{
       connection = DriverManager.getConnection("http://127.0.0.1/home/mysql/", "root", "");
             
            System.out.println("Connexion effectué avec succes ...");
   } catch (SQLException ex) {
            Logger.getLogger(ConnectionBase.class.getName()).log(Level.SEVERE, null, ex);
   }
        
    }
    }
     
    public static  void fermerConnetion(){
        try {
            connection.close();
             System.out.println("Connexion fermée avec succes ...");
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionBase.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
           
      public static Statement creerStatement() throws SQLException{
          return connection.createStatement();
      }
      
      public  static void closeStat(Statement st) throws SQLException{
          st.close();
      }
          
      public static ConnectionBase getInstance(){
          if(instance==null){
              instance=new ConnectionBase();
          }
          return instance;
      }
}

