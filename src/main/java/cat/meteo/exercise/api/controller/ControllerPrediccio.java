/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.meteo.exercise.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import cat.meteo.exercise.api.model.dades.PrediccioMunicipi;
import cat.meteo.exercise.api.model.metadades.Municipi;
import cat.meteo.exercise.api.service.ServiceMetadades;
import cat.meteo.exercise.api.service.ServicePrediccio;
import java.io.FileNotFoundException;
import java.util.List;

/**
 *
 * @author marc
 */

@Controller
@RequestMapping("/municipis")
public class ControllerPrediccio {
    
    @Autowired
    private ServicePrediccio sPred;
    
    @Autowired
    private ServiceMetadades sMeta;
    
    
    @RequestMapping(method = RequestMethod.GET, value = "/{codiMunicipi}")
    @ResponseBody
    public PrediccioMunicipi getPrediccioMunicipi (@PathVariable("codiMunicipi") int codiMunicipi) throws FileNotFoundException, Exception {

        return sPred.getPrediccio(codiMunicipi);
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/metadades")
    @ResponseBody
    public List<Municipi> getMetadadesMunicipis () throws FileNotFoundException {

        return sMeta.getMetadataMunicipis();
    }
}