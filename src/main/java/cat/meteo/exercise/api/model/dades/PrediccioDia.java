/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.meteo.exercise.api.model.dades;

/**
 *
 * @author marc
 */
public class PrediccioDia {
    
    private String data;
    private VariablesPrediccio variables;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public VariablesPrediccio getVariables() {
        return variables;
    }

    public void setVariables(VariablesPrediccio variables) {
        this.variables = variables;
    }
}