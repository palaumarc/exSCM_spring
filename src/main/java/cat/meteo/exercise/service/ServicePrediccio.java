/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.meteo.exercise.service;

import cat.meteo.exercise.dataaccess.DaoPrediccio;
import cat.meteo.exercise.model.PrediccioDia;
import cat.meteo.exercise.model.PrediccioMunicipi;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author marc
 */

@Service
public class ServicePrediccio {
    
    @Autowired
    private DaoPrediccio daoPrediccio;
    
    public PrediccioMunicipi getPrediccio(int codiMunicipi) {
        List<PrediccioMunicipi> prediccions = null;
        PrediccioMunicipi selectedPred = null;
        
        try {
            prediccions = daoPrediccio.getAllPrediccions();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ServicePrediccio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (prediccions == null) {
            throw new RuntimeException();
        }
        
        for (PrediccioMunicipi pred : prediccions) {
            if (pred.getCodi() == codiMunicipi) {
                selectedPred = pred;
                break;
            }
        }
        
        return selectedPred;
    }
}