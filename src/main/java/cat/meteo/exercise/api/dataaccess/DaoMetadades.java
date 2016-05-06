/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.meteo.exercise.api.dataaccess;

import cat.meteo.exercise.api.model.metadades.Municipi;
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
public class DaoMetadades {
    
    @Autowired
    private Gson gson;
    
    @Value("${metadades_municipis}")
    private String metadades_municipis;

    public List<Municipi> getAllMetadades() throws FileNotFoundException {
        List<Municipi> municipis = null;
        
        InputStream inputStream = DaoMetadades.class.getClassLoader().getResourceAsStream(metadades_municipis);
        
        if (inputStream == null) {
            throw new FileNotFoundException(metadades_municipis + " does not exist");
        }
        
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        municipis = gson.fromJson(br, new TypeToken<List<Municipi>>(){}.getType());

        return municipis;
    }
}
