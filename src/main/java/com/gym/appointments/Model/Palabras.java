package com.gym.appointments.Model;

import com.gym.appointments.Repository.PalabrasRepository;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Palabras {

    List<String> palabras;
    PalabrasRepository palabrasRepository;

    public Palabras() {
    }

    private void obtenerListaDepalabras(int categoria) {
        this.palabras = new ArrayList<>();
        palabrasRepository = new PalabrasRepository();

         if(categoria == 2){
            this.palabras = palabrasRepository.getAnimales();
        }else if(categoria == 3){
            this.palabras = palabrasRepository.getNaturaleza();
        }else if(categoria == 4){
            this.palabras = palabrasRepository.getFiguras();
        }else if(categoria == 5){
            this.palabras = palabrasRepository.getHogar();
        }else if(categoria == 6){
            this.palabras = palabrasRepository.getFamilia();
        }else if(categoria == 7){
            this.palabras = palabrasRepository.getPaises();
        }else if(categoria == 8){
            this.palabras = palabrasRepository.getCuidades();
        }else if(categoria == 9){
            this.palabras = palabrasRepository.getDeporte();
        }else if(categoria == 10){
            this.palabras = palabrasRepository.getProfesiones();
        }else if(categoria == 11){
            this.palabras = palabrasRepository.getColores();
        }else{
            this.palabras = palabrasRepository.getTodasLasPalabras();
        }
    }

    public String palabraRandom(){
        int palabrasSize = this.palabras.size();
        String palabra = palabras.get((int) (Math.random()* palabrasSize));
        return palabra;
    }

    public List<String> palabrasRandom(int altura, int ancho, int categoria){
      this.obtenerListaDepalabras(categoria);
      List<String> listPalabras = new ArrayList<>();
        int numeroPalabras = 0;

        if(ancho > altura){
             numeroPalabras = (int) (Math.random() * ancho/2 + 1);
        }else{
             numeroPalabras = (int) (Math.random() * altura/2 + 1);
        }

      if(numeroPalabras != 0) {

          final boolean[] palabraExiste = {false};
          while (numeroPalabras > 0 && listPalabras.size() < this.palabras.size()) {

              String palabra = palabraRandom();

              listPalabras.stream().forEach(it -> {
                  if(it.equals(palabra)){
                      palabraExiste[0] = true;
                  }
              });
              if(!palabraExiste[0]){
                  if (palabra.length() <= ancho || palabra.length() <= altura) {
                      listPalabras.add(palabra);
                  }
              }else{
                  palabraExiste[0] = false;
              }
              numeroPalabras --;
          }
          return listPalabras;
      }else{
          return listPalabras;
      }
    }

}
