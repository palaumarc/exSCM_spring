/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.meteo.exercise.api.model.metadades;

/**
 *
 * @author marc
 */
public class Municipi {
    
    private int codi;
    private String nom;
    private Coordenades coordenades;
    private Comarca comarca;

    public int getCodi() {
        return codi;
    }

    public void setCodi(int codi) {
        this.codi = codi;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Coordenades getCoordenades() {
        return coordenades;
    }

    public void setCoordenades(Coordenades coordenades) {
        this.coordenades = coordenades;
    }

    public Comarca getComarca() {
        return comarca;
    }

    public void setComarca(Comarca comarca) {
        this.comarca = comarca;
    }
    
}
