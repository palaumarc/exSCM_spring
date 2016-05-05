/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.meteo.exercise.dataaccess;

import cat.meteo.exercise.model.PrediccioMunicipi;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author marc
 */

@Repository
public class DaoPrediccio {
    
    private final String jsonFile = "/home/marc/Documents/exercici/material/prediccions_municipals.json";
    JsonReader reader = null;
        
    public List<PrediccioMunicipi> getAllPrediccions() throws FileNotFoundException {
        
        reader = new JsonReader(new InputStreamReader(new FileInputStream(jsonFile)));
        
        Gson myGson = new Gson();
        JsonParser jsonParser = new JsonParser();
        JsonArray predJsonArray = jsonParser.parse(reader).getAsJsonArray();

        List<PrediccioMunicipi> prediccions = new ArrayList<PrediccioMunicipi>();
        for(JsonElement predJson : predJsonArray) {
            PrediccioMunicipi pred = myGson.fromJson(predJson, PrediccioMunicipi.class);
            prediccions.add(pred);
        }
        
        return prediccions;
    }
}
