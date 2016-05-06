/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.meteo.exercise.api.service;

import java.io.FileNotFoundException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author marc
 */

public class ServicePrediccioTest {
    
    @Autowired
    private ServicePrediccio sPred;

    @Test
    public void testGetPrediccioValidId() throws FileNotFoundException{
        
        int id = 82191;
        sPred.getPrediccio(id);
        
    }
    
//    @Test(expected = IllegalArgumentException.class)  
//    public void testGetPrediccioInvalidId() throws FileNotFoundException{
//        
//        int id = 82190;
//        sPred.getPrediccio(id);
//        
//    }
    
    
    
}
