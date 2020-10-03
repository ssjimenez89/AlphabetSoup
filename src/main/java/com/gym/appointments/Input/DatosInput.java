package com.gym.appointments.Input;

import com.gym.appointments.Model.CategoriasPalabras;
import com.gym.appointments.Model.Ubicacion;

import java.util.List;

public class DatosInput extends JsonInput{
    int alto;
    int ancho;
    CategoriasPalabras categoriasPalabras;
    List<Ubicacion> ubicaciones;
    String totalDePalabras;
    List<String> palabras;
    String totalDePalabrasEncontradas;
    List<String> palabrasEncontradas;

    public DatosInput() {
    }

    public DatosInput(int alto, int ancho, CategoriasPalabras categoriasPalabras, List<Ubicacion> ubicaciones, String totalDePalabras, List<String> palabras, String totalDePalabrasEncontradas, List<String> palabrasEncontradas) {
        this.alto = alto;
        this.ancho = ancho;
        this.categoriasPalabras = categoriasPalabras;
        this.ubicaciones = ubicaciones;
        this.totalDePalabras = totalDePalabras;
        this.palabras = palabras;
        this.totalDePalabrasEncontradas = totalDePalabrasEncontradas;
        this.palabrasEncontradas = palabrasEncontradas;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public CategoriasPalabras getCategoriasPalabras() {
        return categoriasPalabras;
    }

    public void setCategoriasPalabras(CategoriasPalabras categoriasPalabras) {
        this.categoriasPalabras = categoriasPalabras;
    }

    public List<Ubicacion> getUbicaciones() {
        return ubicaciones;
    }

    public void setUbicaciones(List<Ubicacion> ubicaciones) {
        this.ubicaciones = ubicaciones;
    }

    public String getTotalDePalabras() {
        return totalDePalabras;
    }

    public void setTotalDePalabras(String totalDePalabras) {
        this.totalDePalabras = totalDePalabras;
    }

    public List<String> getPalabras() {
        return palabras;
    }

    public void setPalabras(List<String> palabras) {
        this.palabras = palabras;
    }

    public String getTotalDePalabrasEncontradas() {
        return totalDePalabrasEncontradas;
    }

    public void setTotalDePalabrasEncontradas(String totalDePalabrasEncontradas) {
        this.totalDePalabrasEncontradas = totalDePalabrasEncontradas;
    }

    public List<String> getPalabrasEncontradas() {
        return palabrasEncontradas;
    }

    public void setPalabrasEncontradas(List<String> palabrasEncontradas) {
        this.palabrasEncontradas = palabrasEncontradas;
    }
}
