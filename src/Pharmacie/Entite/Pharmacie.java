/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Pharmacie.Entite;

import java.util.Objects;

/**
 *
 * @author SAMSUNG
 */
public class Pharmacie {
    
    private int id_pharmacie;
    private String label_phcie;
    private String adresse_phcie;
    private String tel;
    private String jn;
    private double altitude;
    private double longitude;
    private String gouvernorat;
    private String region;
    private String horaire;
    private String garde;
    private boolean infirmerie;
    private boolean cnss;
    private boolean livraison;

    public Pharmacie() {
    }

    public Pharmacie(int id_pharmacie, String label_phcie, String adresse_phcie, String tel, String jn, double altitude, double longitude, String gouvernorat, String region, String horaire, String garde, boolean infirmerie, boolean cnss, boolean livraison) {
        this.id_pharmacie = id_pharmacie;
        this.label_phcie = label_phcie;
        this.adresse_phcie = adresse_phcie;
        this.tel = tel;
        this.jn = jn;
        this.altitude = altitude;
        this.longitude = longitude;
        this.gouvernorat = gouvernorat;
        this.region = region;
        this.horaire = horaire;
        this.garde = garde;
        this.infirmerie = infirmerie;
        this.cnss = cnss;
        this.livraison = livraison;
    }

    public boolean isInfirmerie() {
        return infirmerie;
    }

    public void setInfirmerie(boolean infirmerie) {
        this.infirmerie = infirmerie;
    }

    public boolean isCnss() {
        return cnss;
    }

    public void setCnss(boolean cnss) {
        this.cnss = cnss;
    }

    public boolean isLivraison() {
        return livraison;
    }

    public void setLivraison(boolean livraison) {
        this.livraison = livraison;
    }

  

    /**
     * @return the id_pharmacie
     */
    public int getId_pharmacie() {
        return id_pharmacie;
    }

    /**
     * @param id_pharmacie the id_pharmacie to set
     */
    public void setId_pharmacie(int id_pharmacie) {
        this.id_pharmacie = id_pharmacie;
    }

    /**
     * @return the label_phcie
     */
    public String getLabel_phcie() {
        return label_phcie;
    }

    /**
     * @param label_phcie the label_phcie to set
     */
    public void setLabel_phcie(String label_phcie) {
        this.label_phcie = label_phcie;
    }

    /**
     * @return the adresse_phcie
     */
    public String getAdresse_phcie() {
        return adresse_phcie;
    }

    /**
     * @param adresse_phcie the adresse_phcie to set
     */
    public void setAdresse_phcie(String adresse_phcie) {
        this.adresse_phcie = adresse_phcie;
    }

    /**
     * @return the tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * @param tel the tel to set
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * @return the jn
     */
    public String getJn() {
        return jn;
    }

    /**
     * @param jn the jn to set
     */
    public void setJn(String jn) {
        this.jn = jn;
    }

    /**
     * @return the altitude
     */
    public double getAltitude() {
        return altitude;
    }

    /**
     * @param altitude the altitude to set
     */
    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    /**
     * @return the longitude
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * @param longitude the longitude to set
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * @return the gouvernorat
     */
    public String getGouvernorat() {
        return gouvernorat;
    }

    /**
     * @param gouvernorat the gouvernorat to set
     */
    public void setGouvernorat(String gouvernorat) {
        this.gouvernorat = gouvernorat;
    }

    /**
     * @return the region
     */
    public String getRegion() {
        return region;
    }

    /**
     * @param region the region to set
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * @return the horaire
     */
    public String getHoraire() {
        return horaire;
    }

    /**
     * @param horaire the horaire to set
     */
    public void setHoraire(String horaire) {
        this.horaire = horaire;
    }

    /**
     * @return the garde
     */
    public String getGarde() {
        return garde;
    }

    /**
     * @param garde the garde to set
     */
    public void setGarde(String garde) {
        this.garde = garde;
    }

    @Override
    public String toString() {
        return "Pharmacie{" + "id_pharmacie=" + id_pharmacie + ", label_phcie=" + label_phcie + ", adresse_phcie=" + adresse_phcie + ", tel=" + tel + ", jn=" + jn + ", altitude=" + altitude + ", longitude=" + longitude + ", gouvernorat=" + gouvernorat + ", region=" + region + ", horaire=" + horaire + ", garde=" + garde + ", infirmerie=" + infirmerie + ", cnss=" + cnss + ", livraison=" + livraison + '}';
    }

   
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.id_pharmacie;
        hash = 13 * hash + Objects.hashCode(this.label_phcie);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pharmacie other = (Pharmacie) obj;
        if (this.id_pharmacie != other.id_pharmacie) {
            return false;
        }
        if (!Objects.equals(this.label_phcie, other.label_phcie)) {
            return false;
        }
        return true;
    }
    
    
    
}
