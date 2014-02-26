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
public class Gouvernorat {
    private String id_gouv;
    private String lab_gouv;
    private double latitude_gouv;
    private double longitude_gouv;

    public Gouvernorat() {
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.id_gouv);
        hash = 37 * hash + Objects.hashCode(this.lab_gouv);
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
        final Gouvernorat other = (Gouvernorat) obj;
        if (!Objects.equals(this.id_gouv, other.id_gouv)) {
            return false;
        }
        if (!Objects.equals(this.lab_gouv, other.lab_gouv)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Gouvernorat{" + "id_gouv=" + id_gouv + ", lab_gouv=" + lab_gouv + ", latitude_gouv=" + latitude_gouv + ", longitude_gouv=" + longitude_gouv + '}';
    }

    public String getId_gouv() {
        return id_gouv;
    }

    public void setId_gouv(String id_gouv) {
        this.id_gouv = id_gouv;
    }

    public String getLab_gouv() {
        return lab_gouv;
    }

    public void setLab_gouv(String lab_gouv) {
        this.lab_gouv = lab_gouv;
    }

    public double getLatitude_gouv() {
        return latitude_gouv;
    }

    public void setLatitude_gouv(double latitude_gouv) {
        this.latitude_gouv = latitude_gouv;
    }

    public double getLongitude_gouv() {
        return longitude_gouv;
    }

    public void setLongitude_gouv(double longitude_gouv) {
        this.longitude_gouv = longitude_gouv;
    }

    public Gouvernorat(String id_gouv, String lab_gouv, double latitude_gouv, double longitude_gouv) {
        this.id_gouv = id_gouv;
        this.lab_gouv = lab_gouv;
        this.latitude_gouv = latitude_gouv;
        this.longitude_gouv = longitude_gouv;
    }

}
