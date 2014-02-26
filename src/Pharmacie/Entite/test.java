/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Pharmacie.Entite;

import Connection.ConnectionBase;
import Connection.MyConnection;
import Pharmacie.DAO.PharmacieDAO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author SAMSUNG
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MyConnection.getInstance();
        PharmacieDAO x=new PharmacieDAO();
        // System.out.println( x.findById(2002));
       //Pharmacie p=new Pharmacie(2002, "bbbb", "tttt", "lllll", "n", 12, 36, "TN-11", "gg", "hh", "hhh",true,true,false);
        //Pharmacie p1=new Pharmacie(45, "hjskj", "gg", "gg", "gh", 12, 36, "gg", "gg", "hh", "hhh");
       
      //
        
    
       // x.insertPharmacie(p1);
      //  System.out.println("bilel");
      /* Set e= x.afficherSelonCriterePharmcies("", "LE BARDO", 'j', false, false, false);
        System.out.println(e.size()); 
       Iterator it = e.iterator();
        while (it.hasNext()) {
            Pharmacie q = (Pharmacie) it.next();
            System.out.println(q);
         
        }*/
      // String[] e=x.findRegionByGouv("");
       //int j=0;
        ArrayList<Pharmacie> n=x.afficherSelonCriterePharmcies("", "LE BARDO", 'j', false, false, false);
        for(int i=0;i<n.size();i++){
           
            System.out.println(n.get(i));
        }
       
    }
        
    
}
