/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.meteo.exercise.api.dataaccess;

import cat.meteo.exercise.api.model.metadades.Municipi;
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
public class DaoMetadades {
    
    private final String jsonFile = "/home/marc/Documents/exercici/material/metadades_municipis.json";
    JsonReader reader = null;
        
    public List<Municipi> getAllMetadades() throws FileNotFoundException {
        
        reader = new JsonReader(new InputStreamReader(new FileInputStream(jsonFile)));
        List<Municipi> metadades = null;
        
        Gson myGson = new Gson();
        JsonParser jsonParser = new JsonParser();
        JsonArray predJsonArray = jsonParser.parse(reader).getAsJsonArray();

        metadades = new ArrayList<Municipi>();
        for(JsonElement predJson : predJsonArray) {
            Municipi mun = myGson.fromJson(predJson, Municipi.class);
            metadades.add(mun);
        }
        
        return metadades;
    }
}
