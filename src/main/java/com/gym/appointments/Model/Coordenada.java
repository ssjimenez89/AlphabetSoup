package com.gym.appointments.Model;

import java.util.List;

public class Coordenada {

    int coordenadaAlturaInicial;
    int coordenadaAnchoInicial;
    int coordenadaAlturaFinal;
    int coordenadaAnchoFinal;
    int longitud;
    List<Par> pares;
    Ubicacion ubicacion;

    public Coordenada() {
    }

    public Coordenada( int coordenadaAlturaInicial, int coordenadaAnchoInicial, int coordenadaAlturaFinal,  int coordenadaAnchoFinal, int longitud, List<Par> pares,  Ubicacion ubicacion) {
        this.coordenadaAlturaInicial = coordenadaAlturaInicial;
        this.coordenadaAnchoInicial = coordenadaAnchoInicial;
        this.coordenadaAlturaFinal = coordenadaAlturaFinal;
        this.coordenadaAnchoFinal = coordenadaAnchoFinal;
        this.longitud = longitud;
        this.pares = pares;
        this.ubicacion = ubicacion;
    }

    public int getCoordenadaAnchoInicial() {
        return coordenadaAnchoInicial;
    }

    public void setCoordenadaAnchoInicial(int coordenadaAnchoInicial) {
        this.coordenadaAnchoInicial = coordenadaAnchoInicial;
    }

    public int getCoordenadaAlturaInicial() {
        return coordenadaAlturaInicial;
    }

    public void setCoordenadaAlturaInicial(int coordenadaAlturaInicial) {
        this.coordenadaAlturaInicial = coordenadaAlturaInicial;
    }

    public int getCoordenadaAnchoFinal() {
        return coordenadaAnchoFinal;
    }

    public void setCoordenadaAnchoFinal(int coordenadaAnchoFinal) {
        this.coordenadaAnchoFinal = coordenadaAnchoFinal;
    }

    public int getCoordenadaAlturaFinal() {
        return coordenadaAlturaFinal;
    }

    public void setCoordenadaAlturaFinal(int coordenadaAlturaFinal) {
        this.coordenadaAlturaFinal = coordenadaAlturaFinal;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public List<Par> getPares() {
        return pares;
    }

    public void setPares(List<Par> pares) {
        this.pares = pares;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }
}
