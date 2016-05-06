/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.meteo.exercise.api.service;

import cat.meteo.exercise.api.dataaccess.DaoMetadades;
import cat.meteo.exercise.api.model.metadades.Municipi;
import java.io.FileNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 *
 * @author marc
 */

@Service
public class ServiceMetadades {
    
    @Autowired
    private DaoMetadades daoMetadades;
    
    @Value("${metadades_municipis}")
    private String pathToMetadadesMunicipisFile;
    
    public List<Municipi> getMetadataMunicipis() throws FileNotFoundException {
        return daoMetadades.getAllMetadades(pathToMetadadesMunicipisFile);
    }
    
}
