/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.meteo.exercise.api.dataaccess;

import cat.meteo.exercise.api.model.dades.PrediccioMunicipi;
import cat.meteo.exercise.api.model.metadades.Municipi;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
    public String prediccions_municipals;
    
    public List<PrediccioMunicipi> getAllPrediccions() throws FileNotFoundException {
        
        InputStream inputStream = DaoMetadades.class.getClassLoader().getResourceAsStream(prediccions_municipals);
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

        List<PrediccioMunicipi> prediccions = gson.fromJson(br, new TypeToken<List<PrediccioMunicipi>>(){}.getType());

        return prediccions;
    }
}
