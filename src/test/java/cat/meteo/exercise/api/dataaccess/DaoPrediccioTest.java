/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.meteo.exercise.api.dataaccess;

import cat.meteo.exercise.api.model.dades.PrediccioMunicipi;
import cat.meteo.exercise.commons.config.AppContextConfigTest;
import java.io.FileNotFoundException;
import java.util.List;
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
            DaoPrediccio.class,
            PrediccioMunicipi.class,
            AppContextConfigTest.class
        })
public class DaoPrediccioTest {
    
    @Autowired
    private DaoPrediccio daoPred;
    
    @Value("${prediccions_municipals}")
    private String validPath;
            
    @Value("${invalid_prediccions_municipals}")
    private String invalidPath;
    
    @Test
    public void testGetPrediccio() throws Exception {
        
        List<PrediccioMunicipi> prediccions = null;
        prediccions = daoPred.getAllPrediccions(validPath);
        assertNotNull("Hash de metadades carregat correctament", prediccions);
    }
    
    @Test(expected = FileNotFoundException.class)  
    public void testGetPrediccioWrongPath() throws Exception {
        
        List<PrediccioMunicipi> prediccions = null;
        prediccions = daoPred.getAllPrediccions(invalidPath);
    }
}