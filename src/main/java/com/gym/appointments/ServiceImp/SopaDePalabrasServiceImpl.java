package com.gym.appointments.ServiceImp;

import com.gym.appointments.Input.AlphabetSoupInput;
import com.gym.appointments.Input.DatosInput;
import com.gym.appointments.Input.JsonInput;
import com.gym.appointments.Input.MensajeInput;
import com.gym.appointments.Model.*;
import com.gym.appointments.Service.SopaDePalabrasService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import sun.security.provider.certpath.OCSPResponse;

import java.lang.Error;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class SopaDePalabrasServiceImpl implements SopaDePalabrasService {

    AlphabetSoup alphabetSoup;

    @Override
    public ResponseEntity<JsonInput> crearSopaDePalabras(AlphabetSoup alphabetSoupNew) {

        //Por defecto valor = 15
        int altura = alphabetSoupNew.getW();
        int ancho = alphabetSoupNew.getH();

        if(altura < 15 || altura > 80){
            altura = 15;
        }
        if(ancho < 15 || ancho > 80){
            ancho = 15;
        }

        List<String> ubicaciones = new ArrayList<>();
        List<Ubicacion> ubicacionList = new ArrayList<>();

        ubicaciones.add("Si"); //HORIZONTAL_IZQUIERDA_DERECHA /0
        ubicacionList.add(Ubicacion.HORIZONTAL_IZQUIERDA_DERECHA);

        ubicaciones.add("No"); //HORIZONTAL_DERECHA_IZQUIERDA /1
        ubicacionList.add(Ubicacion.HORIZONTAL_DERECHA_IZQUIERDA);

        ubicaciones.add("Si"); //VERTICAL_ARRIBA_ABAJO /2
        ubicacionList.add(Ubicacion.VERTICAL_ARRIBA_ABAJO);

        ubicaciones.add("No"); //VERTICAL_ABAJO_ARRIBA /3
        ubicacionList.add(Ubicacion.VERTICAL_ABAJO_ARRIBA);

        ubicaciones.add("No"); //DIAGONAL_IZQUIERDA_DERECHA_ARRIBA_ABAJO /4
        ubicacionList.add(Ubicacion.DIAGONAL_IZQUIERDA_DERECHA_ARRIBA_ABAJO);

        ubicaciones.add("No"); //DIAGONAL_DERECHA_IZQUIERDA_ABAJO_ARRIBA; 5
        ubicacionList.add(Ubicacion.DIAGONAL_DERECHA_IZQUIERDA_ABAJO_ARRIBA);

        ubicaciones.add("No"); //DIAGONAL_IZQUIERDA_DERECHA_ABAJO_ARRIBA /6
        ubicacionList.add(Ubicacion.DIAGONAL_IZQUIERDA_DERECHA_ABAJO_ARRIBA);

        ubicaciones.add("No"); //DIAGONAL_DERECHA_IZQUIERDA_ARRIBA_ABAJO; 7
        ubicacionList.add(Ubicacion.DIAGONAL_DERECHA_IZQUIERDA_ARRIBA_ABAJO);

        //Izquierda Derecha (ltr)
        if(!alphabetSoupNew.isLtr()){
            ubicaciones.set(0, "No");
            ubicacionList.remove(Ubicacion.HORIZONTAL_IZQUIERDA_DERECHA);
        }

        //Derecha Izquierda (rtl)
        if(alphabetSoupNew.isRtl()){
            ubicaciones.set(1, "Si");
        }else{
            ubicacionList.remove(Ubicacion.HORIZONTAL_DERECHA_IZQUIERDA);
        }

        //Arriba hacia Abajo (ttb)
        if(!alphabetSoupNew.isTtb()){
            ubicaciones.set(2, "No");
            ubicacionList.remove(Ubicacion.VERTICAL_ARRIBA_ABAJO);
        }

        //Abajo hacia Arriba (btt)
        if(alphabetSoupNew.isBtt()){
            ubicaciones.set(3, "Si");
        }else{
            ubicacionList.remove(Ubicacion.VERTICAL_ABAJO_ARRIBA);
        }

        //Diagonales (d)
        if(alphabetSoupNew.isD()){
            ubicaciones.set(4, "Si");
            ubicaciones.set(5, "Si");
            ubicaciones.set(6, "Si");
            ubicaciones.set(7, "Si");
        }else{
            ubicacionList.remove(Ubicacion.DIAGONAL_IZQUIERDA_DERECHA_ARRIBA_ABAJO);
            ubicacionList.remove(Ubicacion.DIAGONAL_DERECHA_IZQUIERDA_ABAJO_ARRIBA);
            ubicacionList.remove(Ubicacion.DIAGONAL_IZQUIERDA_DERECHA_ABAJO_ARRIBA);
            ubicacionList.remove(Ubicacion.DIAGONAL_DERECHA_IZQUIERDA_ARRIBA_ABAJO);
        }

        int categoria = alphabetSoupNew.getC();
        if(categoria < 1 || categoria > 11){
            categoria = 1;
        }
        SopaDePalabras sp = new SopaDePalabras();
        boolean sopaDePalabrasGenerada = false;
        sopaDePalabrasGenerada = sp.generarSopaDepalabras(altura, ancho, ubicaciones, categoria);

        if(sopaDePalabrasGenerada){

        this.alphabetSoup = new AlphabetSoup();
        this.alphabetSoup.setW(altura);
        this.alphabetSoup.setH(ancho);
        this.alphabetSoup.setLtr(alphabetSoupNew.isLtr());
        this.alphabetSoup.setRtl(alphabetSoupNew.isRtl());
        this.alphabetSoup.setTtb(alphabetSoupNew.isTtb());
        this.alphabetSoup.setBtt(alphabetSoupNew.isBtt());
        this.alphabetSoup.setD(alphabetSoupNew.isD());
        this.alphabetSoup.setC(categoria);
        this.alphabetSoup.setSopaDePalabras(sp);
        this.alphabetSoup.setUbicaciones(ubicacionList);

        AlphabetSoupInput alphabetSoupInput = new AlphabetSoupInput(sp.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(alphabetSoupInput);

        }else{
            String mensaje = "";
            mensaje = "No se pudo crear la Sopa de Palabras";
            MensajeInput mensajeInput = new MensajeInput(mensaje);
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensajeInput);
        }

    }

    @Override
    public ResponseEntity<List<String>> getListaDePalabras(UUID alphabetSoupId) {
        List<String> listMensaje = new ArrayList<>();
        if(this.alphabetSoup != null){
            if(alphabetSoupId.equals(this.alphabetSoup.getSopaDePalabras().getId())){
                return ResponseEntity.status(HttpStatus.OK).body(this.alphabetSoup.getSopaDePalabras().getPalabras());
            }else{
                String mensaje = "El Id es incorrecto ";
                listMensaje.add(mensaje);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(listMensaje);
            }
        }else{
            String mensaje = "No existe una Sopa de Palabras creada";
            listMensaje.add(mensaje);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(listMensaje);
        }

    }

    @Override
    public ResponseEntity<String> getSopaDePalabras(UUID alphabetSoupId) {
        if(this.alphabetSoup != null){
        if(alphabetSoupId.equals(this.alphabetSoup.getSopaDePalabras().getId())){
            Character[][] sopa = this.alphabetSoup.getSopaDePalabras().getSopaPalabras();
            String sopaComoString = "";
            String filasSopa = "";
            for ( int i=0; i<sopa.length; i++ ){
                for ( int j=0; j<sopa[0].length; j++ ){
                  filasSopa = filasSopa + sopa[i][j] + "|";
                }
                filasSopa = filasSopa + "\n";
                sopaComoString = sopaComoString + filasSopa;
                filasSopa = "";
            }
         return ResponseEntity.status(HttpStatus.OK).body(sopaComoString);
        }else{
            String mensaje = " El Id es incorrecto ";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensaje);
        }

        }else{
            String mensaje = "No existe una Sopa de Palabras creada";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensaje);
        }
    }

    @Override
    public ResponseEntity<List<String>> validarCoordenadasDePalabras(UUID alphabetSoupId, CoordenadasInput coordenadasInput) {
        List<String> listMensaje = new ArrayList<>();
        if(this.alphabetSoup != null){
        final boolean[] coordenadasValidas = {false};
        if(alphabetSoupId.equals(this.alphabetSoup.getSopaDePalabras().getId())){
            SopaDePalabras sp = this.alphabetSoup.getSopaDePalabras();

            coordenadasValidas[0] = sp.encontrarPalabraEnSopa(coordenadasInput.getSr() - 1, coordenadasInput.getSc() -1, coordenadasInput.getEr() -1, coordenadasInput.getEc() -1);

            if(coordenadasValidas[0]){

                if(sp.getPalabras().size() == sp.getPalabrasEncontradas().size()){
                    System.out.println("");
                    System.out.println("                         !!!FELICIDADES!!!                          ");
                    System.out.println("----Usted ha ganado el Juego, ya no quedan palabras por descubrir----");

                    String mensaje = "!!!FELICIDADES!!! ----Ha ganado el Juego, ya no quedan palabras por descubrir----";
                    listMensaje.add(mensaje);
                    return ResponseEntity.status(HttpStatus.OK).body(listMensaje);
                }else{
                    String mensaje = "Las coordenadas insertadas son válidas, se ha modificado correctamente la Sopa de Palabras ";
                    listMensaje.add(mensaje);
                    return ResponseEntity.status(HttpStatus.OK).body(listMensaje);
                }

            }else{
                String mensaje = "Las coordenadas insertadas son inválidas o ya han sido encontradas anteriormente, la Sopa de Palabras no ha sido modificada ";
                listMensaje.add(mensaje);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(listMensaje);
            }
        }else{
            String mensaje = " El Id es incorrecto ";
            listMensaje.add(mensaje);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(listMensaje);
        }

        }else{
            String mensaje = "No existe una Sopa de Palabras creada";
            listMensaje.add(mensaje);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(listMensaje);
        }

    }

    @Override
    public ResponseEntity<List<String>> getListaDePalabrasEncontradas(UUID alphabetSoupId) {
        List<String> listMensaje = new ArrayList<>();
        if(this.alphabetSoup != null){
        if(alphabetSoupId.equals(this.alphabetSoup.getSopaDePalabras().getId())){
            return ResponseEntity.status(HttpStatus.OK).body(this.alphabetSoup.getSopaDePalabras().getPalabrasEncontradas());
        }else{
            String mensaje = " El Id es incorrecto ";
            listMensaje.add(mensaje);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(listMensaje);
        }
        }else{
            String mensaje = "No existe una Sopa de Palabras creada";
            listMensaje.add(mensaje);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(listMensaje);
        }
    }

    @Override
    public ResponseEntity<List<String>> getListaDeCoordenasDePalabrasEnSopa(UUID alphabetSoupId) {
        List<String> listMensaje = new ArrayList<>();
        if(this.alphabetSoup != null){
        if(alphabetSoupId.equals(this.alphabetSoup.getSopaDePalabras().getId())){

            List<Coordenada> coordDePalabras = this.alphabetSoup.getSopaDePalabras().getCoordenasDePalabras();
            List<Coordenada> coordDePalabrasEncontradas = this.alphabetSoup.getSopaDePalabras().getCoordenasDePalabrasEncontradas();
            List<String> coordenadasDePalabrasString = new ArrayList<>();

            final int[] contCoordenadas = {0};
            final boolean[] coordEncontradas = {false};

            coordenadasDePalabrasString = coordDePalabras.stream().map(it -> {
                String coordenadas = "";
                coordDePalabrasEncontradas.stream().forEach(it1 -> {
                    if (it.getCoordenadaAlturaInicial() == it1.getCoordenadaAlturaInicial() && it.getCoordenadaAnchoInicial() == it1.getCoordenadaAnchoInicial() && it.getCoordenadaAlturaFinal() == it1.getCoordenadaAlturaFinal() && it.getCoordenadaAnchoFinal() == it1.getCoordenadaAnchoFinal()) {
                        coordEncontradas[0] = true;
                    }
                });
                if(!coordEncontradas[0]){
                    int coordAlturaInicial = it.getCoordenadaAlturaInicial() +1;
                    int coordAnchoInicial = it.getCoordenadaAnchoInicial() +1;
                    int coordAlturaFinal = it.getCoordenadaAlturaFinal() +1;
                    int coordAnchoFinal = it.getCoordenadaAnchoFinal() +1;
                    contCoordenadas[0]++;
                    coordenadas =  contCoordenadas[0] + "-" + "(" + coordAlturaInicial+ "," + coordAnchoInicial + ")" + " " + "(" + coordAlturaFinal + "," + coordAnchoFinal + ")";
                }else{
                    int coordAlturaInicial = it.getCoordenadaAlturaInicial() +1;
                    int coordAnchoInicial = it.getCoordenadaAnchoInicial() +1;
                    int coordAlturaFinal = it.getCoordenadaAlturaFinal() +1;
                    int coordAnchoFinal = it.getCoordenadaAnchoFinal() +1;
                    contCoordenadas[0]++;
                    coordenadas =  contCoordenadas[0] + "-" + "(" + coordAlturaInicial+ "," + coordAnchoInicial + ")" + " " + "(" + coordAlturaFinal + "," + coordAnchoFinal + ")" + " !!!Coordenada encontrada!!! ";
                    coordEncontradas[0] = false;
                }
                return coordenadas;
            }).collect(Collectors.toList());

             return ResponseEntity.status(HttpStatus.OK).body(coordenadasDePalabrasString);
        }else{
            String mensaje = " El Id es incorrecto ";
            listMensaje.add(mensaje);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(listMensaje);
        }
        }else{
            String mensaje = "No existe una Sopa de Palabras creada";
            listMensaje.add(mensaje);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(listMensaje);
        }
    }

    @Override
    public ResponseEntity<JsonInput> getDatosDeLaSopaDepalabras(UUID alphabetSoupId) {
        if(this.alphabetSoup != null){
            if(alphabetSoupId.equals(this.alphabetSoup.getSopaDePalabras().getId())){
                List<Ubicacion> ubicaciones = new ArrayList<>();
               DatosInput datosInput = new DatosInput();
               datosInput.setAlto(this.alphabetSoup.getW());
               datosInput.setAncho(this.alphabetSoup.getH());
               datosInput.setCategoriasPalabras(this.alphabetSoup.getCategoriasPalabrasByOrdinal());
               datosInput.setUbicaciones(this.alphabetSoup.getUbicaciones());
               datosInput.setTotalDePalabras( "(" + this.alphabetSoup.getSopaDePalabras().getPalabras().size() + ")");
               datosInput.setPalabras(this.alphabetSoup.getSopaDePalabras().getPalabras());
               datosInput.setTotalDePalabrasEncontradas("(" + this.alphabetSoup.getSopaDePalabras().getPalabrasEncontradas().size() + "/" +  this.alphabetSoup.getSopaDePalabras().getPalabras().size() + ")");
               datosInput.setPalabrasEncontradas(this.alphabetSoup.getSopaDePalabras().getPalabrasEncontradas());
               return ResponseEntity.status(HttpStatus.OK).body(datosInput);

            }else{
                String mensaje = " El Id es incorrecto ";
                MensajeInput mensajeInput = new MensajeInput(mensaje);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensajeInput);
            }
        }else{
            String mensaje = "No existe una Sopa de Palabras creada";
            MensajeInput mensajeInput = new MensajeInput(mensaje);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensajeInput);
        }
    }

    @Override
    public ResponseEntity<JsonInput> deleteSopaDePalabra(UUID alphabetSoupId) {
        if(this.alphabetSoup != null){
            if(alphabetSoupId.equals(this.alphabetSoup.getSopaDePalabras().getId())){
                this.alphabetSoup = null;
                String mensaje = "La Sopa de Palabras ha sido eliminada correctamente";
                MensajeInput mensajeInput = new MensajeInput(mensaje);
                return ResponseEntity.status(HttpStatus.OK).body(mensajeInput);

            }else{
                String mensaje = " El Id es incorrecto ";
                MensajeInput mensajeInput = new MensajeInput(mensaje);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensajeInput);
            }
        }else{
            String mensaje = "No existe una Sopa de Palabras creada";
            MensajeInput mensajeInput = new MensajeInput(mensaje);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensajeInput);
        }

    }

}
