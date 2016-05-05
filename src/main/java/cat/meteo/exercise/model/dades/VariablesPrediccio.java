/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.meteo.exercise.model.dades;

/**
 *
 * @author marc
 */
public class VariablesPrediccio {
    
    private VarUnitatValor precipitacio;
    private VarUnitatsValor tmax;
    private VarUnitatsValor tmin;
    private VarSimbol estatCel;

    public VarUnitatValor getPrecipitacio() {
        return precipitacio;
    }

    public void setPrecipitacio(VarUnitatValor precipitacio) {
        this.precipitacio = precipitacio;
    }

    public VarUnitatsValor getTmax() {
        return tmax;
    }

    public void setTmax(VarUnitatsValor tmax) {
        this.tmax = tmax;
    }

    public VarUnitatsValor getTmin() {
        return tmin;
    }

    public void setTmin(VarUnitatsValor tmin) {
        this.tmin = tmin;
    }

    public VarSimbol getEstatCel() {
        return estatCel;
    }

    public void setEstatCel(VarSimbol estatCel) {
        this.estatCel = estatCel;
    }
}
