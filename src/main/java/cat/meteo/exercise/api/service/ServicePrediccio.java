/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.meteo.exercise.api.service;

import cat.meteo.exercise.api.dataaccess.DaoPrediccio;
import cat.meteo.exercise.api.model.dades.PrediccioMunicipi;
import java.io.FileNotFoundException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 *
 * @author marc
 */

@Service
public class ServicePrediccio {
    
    @Autowired
    private DaoPrediccio daoPrediccio;
    
    @Value("${prediccions_municipals}")
    private String prediccions_municipals;
    
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    
    public PrediccioMunicipi getPrediccio(int codiMunicipi) throws FileNotFoundException, IllegalArgumentException {
        List<PrediccioMunicipi> prediccions = null;
        PrediccioMunicipi selectedPred = null;
        
        prediccions = daoPrediccio.getAllPrediccions(prediccions_municipals);
        
        for (PrediccioMunicipi pred : prediccions) {
            if (pred.getCodi() == codiMunicipi) {
                selectedPred = pred;
                break;
            }
        }
        
        if (selectedPred == null) {
            log.error("Error seleccionant predicció de municipi: codi no vàlid");
            throw new IllegalArgumentException("Codi de municipi no vàlid");
        }
        
        log.debug("Predicció del municipi amb codi " + codiMunicipi + " seleccionada");
        return selectedPred;
    }
}