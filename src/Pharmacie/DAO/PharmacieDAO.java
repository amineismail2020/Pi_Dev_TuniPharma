/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Pharmacie.DAO;


import Connection.MyConnection;
import Pharmacie.Entite.Gouvernorat;
import Pharmacie.Entite.Pharmacie;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.ArrayList;

/**
 *
 * @author SAMSUNG
 */
public class PharmacieDAO {

    private ArrayList<Pharmacie> pharmacies=new ArrayList<Pharmacie>();
    
   //cette methode permet d'initialiser la collection de parmacies lors de l'instanciation de la classe
    private void initialiser() {
        String requete = "select * from pharmacie ";
        try {
           Statement statement = MyConnection.getInstance().createStatement();
            ResultSet res = statement.executeQuery(requete);

            while (res.next()) {
               int id_pharmacie=res.getInt(1);
               String label_phcie=res.getString(2);
               String adresse_phcie=res.getString(3);
               String tel=res.getString(4);
               String jn=res.getString(5);
               double altitude=res.getDouble(6);
               double longitude=res.getDouble(7);
               String gouvernorat=res.getString(8);
               String region=res.getString(9);
               String horaire=res.getString(10);
               String garde=res.getString(11);
               boolean infirmerie=res.getBoolean(12);
               boolean cnss=res.getBoolean(13);
               boolean livraison=res.getBoolean(14);
               pharmacies.add(new Pharmacie(id_pharmacie,label_phcie,adresse_phcie,tel,jn,altitude,longitude,gouvernorat,region,horaire,garde,infirmerie,cnss,livraison));
               
            }
            
           
         }catch (SQLException ex) {
           
            System.out.println("erreur lors du chargement des depots "+ex.getMessage());
            
        }
         
    }

    
    public PharmacieDAO(){
        this.initialiser();
    }
    
    //Cette méthode permet d'afficher l'attributs collection de pharmacies 
    public void afficher (){
        System.out.println(pharmacies.size());
         Iterator it = pharmacies.iterator();
        while (it.hasNext()) {
            Pharmacie p = (Pharmacie) it.next();
            System.out.println(p);
         
        }
    }
    
        //cette methode permet d'insérer une pharmacie dans la table pharmcie
          public void insertPharmacie(Pharmacie p){

        String requete = "insert into pharmacie (id_pharmacie,label_phcie,adresse_phcie,tel,jn,altitude,longitude,gouvernorat,region,horaire,garde,infirmerie,cnss,livraison) values ("+p.getId_pharmacie()+",'"+p.getLabel_phcie()+"','"+p.getAdresse_phcie()+"','"+ p.getTel()+"','"+p.getJn()+"',"+p.getAltitude()+","+p.getLongitude()+",'"+p.getGouvernorat()+"','"+p.getRegion()+"','"+p.getHoraire()+"','"+p.getGarde()+"',"+p.isInfirmerie()+","+p.isCnss()+","+p.isLivraison()+")";
        try {
          Statement ps = MyConnection.getInstance().createStatement();

            ps.executeUpdate(requete);
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
           
            System.out.println("erreur lors de l'insertion "+ex.getMessage());
        }
    }
     
          //cette methode permet de mettre à jour une pharmacie précise
      public void updatePharmacie(Pharmacie p,int id_pharmacie){

        
        String requete = "update pharmacie set label_phcie='"+p.getLabel_phcie()+"',adresse_phcie='"+p.getAdresse_phcie()+"',tel='"+ p.getTel()+"',jn='"+p.getJn()+"',altitude="+p.getAltitude()+",longitude="+p.getLongitude()+",gouvernorat='"+p.getGouvernorat()+"',region='"+p.getRegion()+"',horaire='"+p.getHoraire()+"',garde='"+p.getGarde()+"',infirmerie="+p.isInfirmerie()+",cnss="+p.isCnss()+",livraison="+p.isLivraison()+" where id_pharmacie="+id_pharmacie;
          try {
          Statement ps = MyConnection.getInstance().createStatement();

            ps.executeUpdate(requete);
            System.out.println("Mise a jour effectuée avec succès");
        } catch (SQLException ex) {
         
            System.out.println("erreur lors de la mise à jour"+ex.getMessage());
        }
    }
      
      //cette methode permet de supprimer une pharmacie
       public void deletePharmacie(int id_pharmacie){

        
        String requete = "delete from pharmacie  where id_pharmacie="+id_pharmacie;
          try {
          Statement ps = MyConnection.getInstance().createStatement();

            ps.executeUpdate(requete);
            System.out.println("Supression effectuée avec succès");
        } catch (SQLException ex) {
          
            System.out.println("erreur lors de la supression"+ex.getMessage());
        }
    }
      
       //cette methode permet d'afficher tout les pharmacies
     public ArrayList afficherPharmcies() {
        String requete = "select * from pharmacie";
        ArrayList<Pharmacie> phar=new ArrayList<Pharmacie>();
        try {
           Statement statement = MyConnection.getInstance().createStatement();
            ResultSet res = statement.executeQuery(requete);

            while (res.next()) {             
               int id_pharmacie=res.getInt(1);
               String label_phcie=res.getString(2);
               String adresse_phcie=res.getString(3);
               String tel=res.getString(4);
               String jn=res.getString(5);
               double altitude=res.getDouble(6);
               double longitude=res.getDouble(7);
               String gouvernorat=res.getString(8);
               String region=res.getString(9);
               String horaire=res.getString(10);
               String garde=res.getString(11);
               boolean infirmerie=res.getBoolean(12);
               boolean cnss=res.getBoolean(13);
               boolean livraison=res.getBoolean(14);
              
               phar.add(new Pharmacie(id_pharmacie,label_phcie,adresse_phcie,tel,jn,altitude,longitude,gouvernorat,region,horaire,garde,infirmerie,cnss,livraison));
               
            }
       
            
            return phar;
         }catch (SQLException ex) {
           
            System.out.println("erreur lors du chargement des depots "+ex.getMessage());
            
            return null;
        }
         
    }

     //cette methode permet de rechercher une pharmacie selon son identifiant
      public Pharmacie findById(int id_pharmaciee) {
        String requete = "select * from pharmacie where id_pharmacie="+id_pharmaciee;
        
        try {
            Pharmacie p;
           Statement statement = MyConnection.getInstance().createStatement();
            ResultSet res = statement.executeQuery(requete);
                
           
            if(!res.wasNull())
            {
                System.out.println("Pharmacie non existante");
                
            }
            else{                
            while (res.next()) {             
               int id_pharmacie=res.getInt(1);
               String label_phcie=res.getString(2);
               String adresse_phcie=res.getString(3);
               String tel=res.getString(4);
               String jn=res.getString(5);
               double altitude=res.getDouble(6);
               double longitude=res.getDouble(7);
               String gouvernorat=res.getString(8);
               String region=res.getString(9);
               String horaire=res.getString(10);
               String garde=res.getString(11);
               boolean infirmerie=res.getBoolean(12);
               boolean cnss=res.getBoolean(13);
               boolean livraison=res.getBoolean(14);
              
               p=new Pharmacie(id_pharmacie,label_phcie,adresse_phcie,tel,jn,altitude,longitude,gouvernorat,region,horaire,garde,infirmerie,cnss,livraison);
               return p;
            }  
          }
            
         }
          catch (SQLException ex) {
           
            System.out.println("erreur lors du chargement des depots "+ex.getMessage());
             
          
        }
        return null;
    }
        //cette methode permet de rechercher une pharmacie selon son labelle
      public Pharmacie findByLabel(String label_ph) {
        String requete = "select * from pharmacie where label_phcie='"+label_ph+"'";
        
        try {
            Pharmacie p;
           Statement statement = MyConnection.getInstance().createStatement();
            ResultSet res = statement.executeQuery(requete);
                
           
            if(!res.wasNull())
            {
                System.out.println("Pharmacie non existante");
                
            }
            else{                
            while (res.next()) {             
               int id_pharmacie=res.getInt(1);
               String label_phcie=res.getString(2);
               String adresse_phcie=res.getString(3);
               String tel=res.getString(4);
               String jn=res.getString(5);
               double altitude=res.getDouble(6);
               double longitude=res.getDouble(7);
               String gouvernorat=res.getString(8);
               String region=res.getString(9);
               String horaire=res.getString(10);
               String garde=res.getString(11);
               boolean infirmerie=res.getBoolean(12);
               boolean cnss=res.getBoolean(13);
               boolean livraison=res.getBoolean(14);
              
               p=new Pharmacie(id_pharmacie,label_phcie,adresse_phcie,tel,jn,altitude,longitude,gouvernorat,region,horaire,garde,infirmerie,cnss,livraison);
               return p;
            }  
          }
            
         }
          catch (SQLException ex) {
           
            System.out.println("erreur lors du chargement des depots "+ex.getMessage());
             
          
        }
        return null;
    }

     //cette methode permet de rechercher une pharmacie selon les critéres de l'interface consultation
      public ArrayList<Pharmacie> afficherSelonCriterePharmcies(String gouv,String reg, char JN,boolean infiremerie, boolean CNSS,boolean livr) {
          GouvernoratDAO g=new GouvernoratDAO();
          String id=gouv;
          if(gouv.trim()!=""){
           id=g.findBylabel(gouv).getId_gouv();}
          
          String requete = "select * from pharmacie where gouvernorat like '"+id+"%' and region like '"+reg+"%' and jn='"+JN+"' and infirmerie="+infiremerie+" and cnss="+CNSS+" and livraison="+livr;
        ArrayList<Pharmacie> phar=new ArrayList<Pharmacie>();
        try {
           Statement statement = MyConnection.getInstance().createStatement();
            ResultSet res = statement.executeQuery(requete);

            while (res.next()) {             
               int id_pharmacie=res.getInt(1);
               String label_phcie=res.getString(2);
               String adresse_phcie=res.getString(3);
               String tel=res.getString(4);
               String jn=res.getString(5);
               double altitude=res.getDouble(6);
               double longitude=res.getDouble(7);
               String gouvernorat=res.getString(8);
               String region=res.getString(9);
               String horaire=res.getString(10);
               String garde=res.getString(11);
               boolean infirmerie=res.getBoolean(12);
               boolean cnss=res.getBoolean(13);
               boolean livraison=res.getBoolean(14);
              
               phar.add(new Pharmacie(id_pharmacie,label_phcie,adresse_phcie,tel,jn,altitude,longitude,gouvernorat,region,horaire,garde,infirmerie,cnss,livraison));
               
            }
       
            
            return phar;
         }catch (SQLException ex) {
           
            System.out.println("erreur lors du chargement des depots "+ex.getMessage());
            
            return null;
        }
         
    }
      public String[] findRegionByGouv(String gouv) {
          
          GouvernoratDAO g=new GouvernoratDAO();
          String label=gouv;
          if(gouv.trim()!=""){
           label=g.findBylabel(gouv).getId_gouv();}
        
        String requete = "select distinct(region) from pharmacie where gouvernorat like'"+label+"%'";
      String[] resultat=new String[350];
        int i=0;
        try {
          
           Statement statement = MyConnection.getInstance().createStatement();
            ResultSet res = statement.executeQuery(requete);
            
            while (res.next()) {             
              
              resultat[i]=res.getString(1).toString();
              i++; 
          }
            
           
            
         }
          catch (SQLException ex) {
           
            System.out.println("erreur lors du chargement des depots "+ex.getMessage());
             
          
        }
        return resultat;
    }

      
      /*   public void insertPharmacie(Pharmacie p){

        String requete = "insert into pharmacie (id_pharmacie,label_phcie,adresse_phcie,tel,jn,altitude,longitude,gouvernorat,region,horaire,garde,infirmerie,cnss,livraison) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
          PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);

          ps.setInt(1, p.getId_pharmacie());
          ps.setString(2, p.getLabel_phcie().toString());
          ps.setString(3, p.getAdresse_phcie().toString());
          ps.setString(4, p.getTel().toString());
          ps.setString(5, p.getJn().toString());
          ps.setDouble(6, p.getAltitude());
          ps.setDouble(7, p.getLongitude());
          ps.setString(8, p.getGouvernorat());
          ps.setString(9, p.getRegion());
          ps.setString(10, p.getHoraire());
          ps.setString(11, p.getGarde());
          ps.setBoolean(12, p.isInfirmerie());
          ps.setBoolean(13, p.isInfirmerie());
          ps.setBoolean(14, p.isLivraison());
            System.out.println("hhh");
          ps.executeUpdate(requete);
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion "+ex.getMessage());
        }
         
         
    }*/
}
