/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.meteo.exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import cat.meteo.exercise.model.PrediccioMunicipi;
import cat.meteo.exercise.service.ServicePrediccio;

/**
 *
 * @author marc
 */

@Controller
@RequestMapping("/municipis")
public class ControllerPrediccio {
    
    @Autowired
    private ServicePrediccio sPred;
    
    @RequestMapping(method = RequestMethod.GET, value = "/{codiMunicipi}")
    @ResponseBody
    public PrediccioMunicipi getPrediccioMunicipi (@PathVariable("codiMunicipi") int codiMunicipi) {

        return sPred.getPrediccio(codiMunicipi);
    }
}