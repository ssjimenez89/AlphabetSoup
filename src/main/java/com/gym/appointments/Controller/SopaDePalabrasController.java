package com.gym.appointments.Controller;

import com.gym.appointments.Input.DatosInput;
import com.gym.appointments.Input.JsonInput;
import com.gym.appointments.Input.MensajeInput;
import com.gym.appointments.Model.*;
import com.gym.appointments.Service.SopaDePalabrasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
//@RequestMapping("/api")
public class SopaDePalabrasController {

    @Autowired
    SopaDePalabrasService sopaDePalabrasService;

    @PostMapping(value = "/alphabetSoup", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<JsonInput> crearSopaDePalabras(@Valid @RequestBody AlphabetSoup alphabetSoup){
        return sopaDePalabrasService.crearSopaDePalabras(alphabetSoup);
    }

    @GetMapping(value = "/alphabetSoup/list/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<String>> getListaDePalabras(@PathVariable(value = "id") UUID alphabetSoupId){
        return sopaDePalabrasService.getListaDePalabras(alphabetSoupId);
    }

    @GetMapping(value = "/alphabetSoup/view/{id}", produces = "text/plain")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> getSopaDePalabras(@PathVariable(value = "id") UUID alphabetSoupId){
        return sopaDePalabrasService.getSopaDePalabras(alphabetSoupId);
    }

    @PutMapping(value = "/alphabetSoup/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<String>> validarCoordenadasDePalabras(@PathVariable(value = "id") UUID alphabetSoupId, @Valid @RequestBody CoordenadasInput coordenadasInput){
        return sopaDePalabrasService.validarCoordenadasDePalabras(alphabetSoupId, coordenadasInput);
    }

    @GetMapping(value = "/alphabetSoup/list/found/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<String>> getListaDePalabrasEncontradas(@PathVariable(value = "id") UUID alphabetSoupId){
        return sopaDePalabrasService.getListaDePalabrasEncontradas(alphabetSoupId);
    }

    @GetMapping(value = "/alphabetSoup/coordinate/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<String>> getListaDeCoordenasDePalabrasEnSopa(@PathVariable(value = "id") UUID alphabetSoupId){
        return sopaDePalabrasService.getListaDeCoordenasDePalabrasEnSopa(alphabetSoupId);
    }

    @GetMapping(value = "/alphabetSoup/data/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<JsonInput> getDatosDeLaSopaDepalabras(@PathVariable(value = "id") UUID alphabetSoupId){
        return sopaDePalabrasService.getDatosDeLaSopaDepalabras(alphabetSoupId);
    }

    @DeleteMapping(value = "/alphabetSoup/{id}", produces = "application/json")
    public ResponseEntity<JsonInput> deleteSopaDePalabra(@PathVariable(value = "id") UUID alphabetSoupId){
       return sopaDePalabrasService.deleteSopaDePalabra(alphabetSoupId);
    }


}
