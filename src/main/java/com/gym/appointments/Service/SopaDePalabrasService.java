package com.gym.appointments.Service;

import com.gym.appointments.Input.DatosInput;
import com.gym.appointments.Input.JsonInput;
import com.gym.appointments.Input.MensajeInput;
import com.gym.appointments.Model.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface SopaDePalabrasService {

    ResponseEntity<JsonInput> crearSopaDePalabras(AlphabetSoup alphabetSoup);

    ResponseEntity<List<String>> getListaDePalabras(UUID alphabetSoupId);

    ResponseEntity<String> getSopaDePalabras(UUID alphabetSoupId);

    ResponseEntity<List<String>> validarCoordenadasDePalabras(UUID alphabetSoupId, CoordenadasInput coordenadasInput);

    ResponseEntity<List<String>> getListaDePalabrasEncontradas(UUID alphabetSoupId);

    ResponseEntity<List<String>> getListaDeCoordenasDePalabrasEnSopa(UUID alphabetSoupId);

    ResponseEntity<JsonInput> getDatosDeLaSopaDepalabras(UUID alphabetSoupId);

    ResponseEntity<JsonInput> deleteSopaDePalabra(UUID alphabetSoupId);
}
