/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.meteo.exercise.model.dades;

import java.util.List;

/**
 *
 * @author marc
 */
public class PrediccioMunicipi {
    
    private int codi;
    private List<PrediccioDia> dies;

    public PrediccioMunicipi(int codiMunicipi, List<PrediccioDia> prediccions) {
        this.codi = codiMunicipi;
        this.dies = prediccions;
    }

    public int getCodi() {
        return codi;
    }

    public void setCodi(int codi) {
        this.codi = codi;
    }

    public List<PrediccioDia> getDies() {
        return dies;
    }

    public void setDies(List<PrediccioDia> dies) {
        this.dies = dies;
    }
    
}
