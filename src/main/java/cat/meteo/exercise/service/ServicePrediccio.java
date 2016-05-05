/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.meteo.exercise.service;

import cat.meteo.exercise.dataaccess.DaoMetadades;
import cat.meteo.exercise.dataaccess.DaoPrediccio;
import cat.meteo.exercise.model.dades.PrediccioMunicipi;
import cat.meteo.exercise.model.metadades.Municipi;
import java.io.FileNotFoundException;
import java.util.List;
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
    
    @Autowired
    private DaoMetadades daoMetadades;
    
    public PrediccioMunicipi getPrediccio(int codiMunicipi) throws FileNotFoundException {
        List<PrediccioMunicipi> prediccions = null;
        PrediccioMunicipi selectedPred = null;
        
        prediccions = daoPrediccio.getAllPrediccions();
        
        for (PrediccioMunicipi pred : prediccions) {
            if (pred.getCodi() == codiMunicipi) {
                selectedPred = pred;
                break;
            }
        }
        
        return selectedPred;
    }
    
    public List<Municipi> getMetadataMunicipis() throws FileNotFoundException {
        
        return daoMetadades.getAllMetadades();
    }
}