/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.cinema.controllers;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.arsw.cinema.persistence.CinemaException;
import edu.eci.arsw.cinema.persistence.CinemaServicesInterface;

@RestController
@RequestMapping(value ="/cinema")
public class CinemaAPIController {
	@Autowired
	@Qualifier("cinemaServices")
	private CinemaServicesInterface css ;
	
	
    @RequestMapping(method = RequestMethod.GET)
    
    public ResponseEntity<?> manejadorGetRecurso()  {
        //obtener datos que se enviarán a través del API
        try {
        	System.out.println("prueba");
            return new ResponseEntity<>(css.getAllCinemas(), HttpStatus.ACCEPTED);
        } catch (CinemaException e) {
        	 Logger.getLogger(CinemaAPIController.class.getName()).log(Level.SEVERE, null, e);
             return new ResponseEntity<>("Error bla bla bla", HttpStatus.NOT_FOUND);
        }
    }
}


