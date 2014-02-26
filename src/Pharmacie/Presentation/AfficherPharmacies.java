/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Pharmacie.Presentation;

import Pharmacie.DAO.PharmacieDAO;
import Pharmacie.Entite.Pharmacie;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author SAMSUNG
 */
public class AfficherPharmacies  extends AbstractTableModel{

List <Pharmacie> pharmacies;
String [] columTab = {"Nom Pharmacie", "Adresse Pharmacie","Téléphone","Horaire de travail"};
    
    public AfficherPharmacies() {
        PharmacieDAO phar = new PharmacieDAO();
        pharmacies = phar.afficherPharmcies();

    }

    public AfficherPharmacies(String gouv,String region,char jn,boolean infirmerie,boolean cnss,boolean livraison) {
        PharmacieDAO phar = new PharmacieDAO();
        pharmacies = phar.afficherSelonCriterePharmcies(gouv, region, jn, infirmerie, cnss, livraison);
      
    }


    public int getRowCount() {
        
        return  pharmacies.size();
    }

    public int getColumnCount() {
       return columTab.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
       switch(columnIndex)
       {
          case 0 : return pharmacies.get(rowIndex).getLabel_phcie();
          case 1 : return pharmacies.get(rowIndex).getAdresse_phcie();
          case 2 : return pharmacies.get(rowIndex).getTel();
          case 3 : return pharmacies.get(rowIndex).getHoraire();    
          default: return null;
       }
    }

    @Override
    public String getColumnName(int column) {
       return  columTab[column];
    }



}
    

