/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Pharmacie.DAO;

import Pharmacie.Entite.Gouvernorat;
import Pharmacie.Entite.Pharmacie;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author SAMSUNG
 */
public class Testgouv {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GouvernoratDAO g=new GouvernoratDAO();
        String[] e=g.afficherGouvernoratsLabel();
        for(int i=0;i<e.length;i++){
            System.out.println(e[i]);
        }
        PharmacieDAO phar=new PharmacieDAO();
        System.out.println(phar.afficherSelonCriterePharmcies("", "", 'j', false, false, false).size());
   }   
}
