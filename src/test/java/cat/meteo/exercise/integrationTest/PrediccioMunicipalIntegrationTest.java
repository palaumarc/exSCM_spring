/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.meteo.exercise.integrationTest;

import cat.meteo.exercise.commons.config.AppContextConfigTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
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
            PrediccioMunicipalIntegrationTest.class,
            TestCalls.class,
            AppContextConfigTest.class
        })
public class PrediccioMunicipalIntegrationTest {
   
    @Value("${restapi_test_port}")
    private int port;
    
    @Value("${valid_municipi_id}")
    private int validId;
            
    @Value("${invalid_municipi_id}")
    private int invalidId;
    
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    
    @Test
    public void testMunicipisMetadades() {
        log.debug("## Executing testMuncipisMetadades ##");
        TestCalls.doGet("/municipis/metadades", port, HttpStatus.OK.value());
    }
    
    @Test
    public void testPrediccionsValidId() {
        log.debug("## Executing testPrediccionsValidId ##");
        TestCalls.doGet("/municipis/" + validId, port, HttpStatus.OK.value());
    }
    
    @Test
    public void testPrediccionsInvalidId() {
        log.debug("## Executing testPrediccionsInvalidId ##");
        TestCalls.doGet("/municipis/" + invalidId, port, HttpStatus.BAD_REQUEST.value());
    }
    
}
