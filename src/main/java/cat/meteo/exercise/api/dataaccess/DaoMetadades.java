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
import org.springframework.stereotype.Repository;

/**
 *
 * @author marc
 */

@Repository
public class DaoMetadades {
    
    @Autowired
    private Gson gson;

    public List<Municipi> getAllMetadades(String pathToMetadadesFile) throws FileNotFoundException {
        
        List<Municipi> municipis = null;
        
        InputStream inputStream = DaoMetadades.class.getClassLoader().getResourceAsStream(pathToMetadadesFile);
        
        if (inputStream == null) {
            throw new FileNotFoundException(pathToMetadadesFile + " does not exist");
        }
        
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        municipis = gson.fromJson(br, new TypeToken<List<Municipi>>(){}.getType());

        return municipis;
    }
}
