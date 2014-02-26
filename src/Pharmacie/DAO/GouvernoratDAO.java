/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Pharmacie.DAO;

import Connection.MyConnection;
import Pharmacie.Entite.Gouvernorat;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author SAMSUNG
 */
public class GouvernoratDAO {
     private ArrayList<Gouvernorat> gouvernorats=new ArrayList<Gouvernorat>();
    
   //cette methode permet d'initialiser la collection de parmacies lors de l'instanciation de la classe
    private void initialiser() {
        String requete = "select * from gouvernaurat ";
        try {
           Statement statement = MyConnection.getInstance().createStatement();
            ResultSet res = statement.executeQuery(requete);

            while (res.next()) {
               String id_gouv=res.getString(1);
               String label_gouv=res.getString(2);
               double altitude=res.getDouble(3);
               double longitude=res.getDouble(4);
             
               gouvernorats.add(new Gouvernorat(id_gouv, label_gouv, altitude, longitude));
               
            }
            
           
         }catch (SQLException ex) {
           
            System.out.println("erreur lors du chargement des depots "+ex.getMessage());
            
        }
         
    }

    
    public GouvernoratDAO(){}
    
    //Cette méthode permet d'afficher l'attributs collection de pharmacies 
    public void afficher (){
        System.out.println(gouvernorats.size());
         Iterator it = gouvernorats.iterator();
        while (it.hasNext()) {
            Gouvernorat p = (Gouvernorat) it.next();
            System.out.println(p);
         
        }
    }
    
        //cette methode permet d'insérer une pharmacie dans la table pharmcie
          public void insertGouvernorat(Gouvernorat g){

        String requete = "insert into gouvernaurat (ID_gouv,lab_gouv,latitude_gouv,longitude_gouv) values ('"+g.getId_gouv()+"','"+g.getLab_gouv()+"',"+g.getLatitude_gouv()+","+g.getLongitude_gouv()+")";
        try {
          Statement ps = MyConnection.getInstance().createStatement();

            ps.executeUpdate(requete);
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
           
            System.out.println("erreur lors de l'insertion "+ex.getMessage());
        }
    }
     
          //cette methode permet de mettre à jour une pharmacie précise
      public void updateGouvernorat(Gouvernorat g,String id_gouv){

        
        String requete = "update gouvernaurat set lab_gouv='"+g.getLab_gouv()+"',laltitude_gouv="+g.getLatitude_gouv()+",longitude_gouv="+g.getLongitude_gouv()+" where ID_gouv='"+id_gouv+"'";
          try {
          Statement ps = MyConnection.getInstance().createStatement();

            ps.executeUpdate(requete);
            System.out.println("Mise a jour effectuée avec succès");
        } catch (SQLException ex) {
         
            System.out.println("erreur lors de la mise à jour"+ex.getMessage());
        }
    }
      
      //cette methode permet de supprimer une pharmacie
       public void deleteGouvernorat(String id_gouv){

        
        String requete = "delete from gouvernaurat  where ID_gouv='"+id_gouv+"'";
          try {
          Statement ps = MyConnection.getInstance().createStatement();

            ps.executeUpdate(requete);
            System.out.println("Supression effectuée avec succès");
        } catch (SQLException ex) {
          
            System.out.println("erreur lors de la supression"+ex.getMessage());
        }
    }
      
       //cette methode permet d'afficher tout les pharmacies
     public ArrayList afficherGouvernorats() {
        
        ArrayList<Gouvernorat> gouv=new ArrayList<Gouvernorat>();
           String requete = "select * from gouvernaurat ";
        try {
           Statement statement = MyConnection.getInstance().createStatement();
            ResultSet res = statement.executeQuery(requete);

            while (res.next()) {
               String id_gouv=res.getString(1);
               String label_gouv=res.getString(2);
               double altitude=res.getDouble(3);
               double longitude=res.getDouble(4);
             
               gouv.add(new Gouvernorat(id_gouv, label_gouv, altitude, longitude));
               
            }
            
            return gouv;
         }catch (SQLException ex) {
           
            System.out.println("erreur lors du chargement des depots "+ex.getMessage());
            return null;
        }
       
         
    }
     
     public String[] afficherGouvernoratsLabel() {
        
       String[] gouv=new String[24];
       int i=0;
           String requete = "select lab_gouv from gouvernaurat ";
        try {
           Statement statement = MyConnection.getInstance().createStatement();
            ResultSet res = statement.executeQuery(requete);

            while (res.next()) {
               
               gouv[i]=res.getString(1);
               i++;
               
            }
            
            return gouv;
         }catch (SQLException ex) {
           
            System.out.println("erreur lors du chargement des depots "+ex.getMessage());
            return null;
        }
       
         
    }
     //cette methode permet de rechercher une pharmacie selon son identifiant
      public Gouvernorat findById(String id_gouvern) {
        String requete = "select * from gouvernaurat where ID_gouv='"+id_gouvern+"'";
        
        try {
            Gouvernorat g;
           Statement statement = MyConnection.getInstance().createStatement();
            ResultSet res = statement.executeQuery(requete);
                
           
            if(res.wasNull())
            {
                System.out.println("Gouvernorat non existant");
                
            }
            else{                
              while (res.next()) {
               String id_gouv=res.getString(1);
               String label_gouv=res.getString(2);
               double altitude=res.getDouble(3);
               double longitude=res.getDouble(4);
             
               g=new Gouvernorat(id_gouv, label_gouv, altitude, longitude);
               return g;
            }  
          }
            
         }
          catch (SQLException ex) {
           
            System.out.println("erreur lors du chargement des depots "+ex.getMessage());
             
          
        }
        return null;
    }
        //cette methode permet de rechercher une pharmacie selon son labelle
       public Gouvernorat findBylabel(String label_gouvern) {
        String requete = "select * from gouvernaurat where lab_gouv='"+label_gouvern+"'";
        
        try {
            Gouvernorat g;
           Statement statement = MyConnection.getInstance().createStatement();
            ResultSet res = statement.executeQuery(requete);
                
           
            if(res.wasNull())
            {
                System.out.println("Gouvernorat non existant");
                
            }
            else{                
              while (res.next()) {
               String id_gouv=res.getString(1);
               String label_gouv=res.getString(2);
               double altitude=res.getDouble(3);
               double longitude=res.getDouble(4);
             
               g=new Gouvernorat(id_gouv, label_gouv, altitude, longitude);
               return g;
            }  
          }
            
         }
          catch (SQLException ex) {
           
            System.out.println("erreur lors du chargement des depots "+ex.getMessage());
             
          
        }
        return null;
    }
    
}
