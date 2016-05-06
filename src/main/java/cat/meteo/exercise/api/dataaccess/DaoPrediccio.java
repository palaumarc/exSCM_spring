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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

/**
 *
 * @author marc
 */

@Repository
public class DaoPrediccio {
    
    @Autowired
    private Gson gson;
    
    @Value("${prediccions_municipals}")
    private String prediccions_municipals;
    
    public List<PrediccioMunicipi> getAllPrediccions() throws FileNotFoundException {
        
        List<PrediccioMunicipi> prediccions;
        
        InputStream inputStream = DaoPrediccio.class.getClassLoader().getResourceAsStream(prediccions_municipals);
        
        if (inputStream == null) {
            throw new FileNotFoundException(prediccions_municipals + " does not exist");
        }
        
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        prediccions = gson.fromJson(br, new TypeToken<List<PrediccioMunicipi>>(){}.getType());

        return prediccions;
    }
}
