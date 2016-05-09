/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.meteo.exercise.api.dataaccess;

import cat.meteo.exercise.api.model.dades.PrediccioMunicipi;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author marc
 */

@Repository
public class DaoPrediccio {
    
    @Autowired
    private Gson gson;
    
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    
    public List<PrediccioMunicipi> getAllPrediccions(String pathToPrediccionsFile) throws FileNotFoundException {
        
        List<PrediccioMunicipi> prediccions;
        
        InputStream inputStream = DaoPrediccio.class.getClassLoader().getResourceAsStream(pathToPrediccionsFile);
        
        if (inputStream == null) {
            log.error(pathToPrediccionsFile + " does not exist");
            throw new FileNotFoundException(pathToPrediccionsFile + " does not exist");
        }
        
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        prediccions = gson.fromJson(br, new TypeToken<List<PrediccioMunicipi>>(){}.getType());

        return prediccions;
    }
}
