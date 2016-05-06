/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.meteo.exercise.commons.config;

import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 *
 * @author marc
 */
/**
 * Configuració programàtica de context que es fa servir a tota l'aplicació (
 * NOMÉS PER A TESTS)
 *
 * @author epa
 */
@Configuration
@PropertySource("classpath:Global-Test.properties")
public class AppContextConfigTest {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
    
    @Bean
    public Gson gson() {
        return new Gson();
    }
}
