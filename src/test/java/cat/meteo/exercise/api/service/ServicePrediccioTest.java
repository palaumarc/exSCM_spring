/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.meteo.exercise.api.service;

import cat.meteo.exercise.api.dataaccess.DaoPrediccio;
import cat.meteo.exercise.api.model.dades.PrediccioMunicipi;
import cat.meteo.exercise.commons.config.AppContextConfigTest;
import java.io.FileNotFoundException;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

/**
 *
 * @author marc
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        loader = AnnotationConfigContextLoader.class,
        classes = {
            ServicePrediccio.class,
            DaoPrediccio.class,
            PrediccioMunicipi.class,
            AppContextConfigTest.class
        })
public class ServicePrediccioTest {
    
    @Autowired
    private ServicePrediccio sPred;
    
    @Value("${valid_municipi_id}")
    private int validId;
            
    @Value("${invalid_municipi_id}")
    private int invalidId;
    
    @Test (expected = IllegalArgumentException.class)  
    public void testGetPrediccioInvalidId() throws Exception {
        PrediccioMunicipi pred;
        pred = sPred.getPrediccio(invalidId);
    }
    
    @Test
    public void testGetPrediccioValidId() throws Exception {
        PrediccioMunicipi pred;
        pred = sPred.getPrediccio(validId);
        assertNotNull("Predicció municipal carregada correctament", pred);
    }   
    
}
