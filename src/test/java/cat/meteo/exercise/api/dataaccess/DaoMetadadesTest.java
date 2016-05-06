/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.meteo.exercise.api.dataaccess;

import cat.meteo.exercise.api.model.metadades.Municipi;
import cat.meteo.exercise.commons.config.AppContextConfigTest;
import java.io.FileNotFoundException;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
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
            DaoMetadades.class,
            Municipi.class,
            AppContextConfigTest.class
        })
public class DaoMetadadesTest {
    
    @Autowired
    private DaoMetadades daoMeta;
    
    @Value("${valid_metadata_municipis}")
    private String validPath;
            
    @Value("${invalid_metadata_municipis}")
    private String invalidPath;
    
    @Test
    public void testGetAllMetadades() throws Exception {
        
        List<Municipi> municipis = null;
        municipis = daoMeta.getAllMetadades(validPath);
        assertNotNull("Ha trobat el json", municipis);
    }
    
    @Test(expected = FileNotFoundException.class)  
    public void testGetAllMetadadesFail() throws Exception {
        
        List<Municipi> municipis = null;
        municipis = daoMeta.getAllMetadades(invalidPath);
    }
    
    
}
