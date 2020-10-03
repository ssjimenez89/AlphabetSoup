package com.gym.appointments.Model;

import java.util.List;
import java.util.UUID;

public class AlphabetSoup {

    int w;
    int h;
    boolean ltr = true;  //Por defecto true
    boolean rtl;         //Por defecto false
    boolean ttb = true;  //Por defecto true
    boolean btt;         //Por defecto false
    boolean d;           //Por defecto false
    int c = 1;           //Categoria, Por defecto Todas las palabras
    SopaDePalabras sopaDePalabras;
    List<Ubicacion> ubicaciones;

    public AlphabetSoup() {
    }

    public AlphabetSoup( int w, int h, boolean ltr, boolean rtl, boolean ttb, boolean btt, boolean d, int c, SopaDePalabras sopaDePalabras, List<Ubicacion> ubicaciones) {
        this.w = w;
        this.h = h;
        this.ltr = ltr;
        this.rtl = rtl;
        this.ttb = ttb;
        this.btt = btt;
        this.d = d;
        this.c = c;
        this.sopaDePalabras = sopaDePalabras;
        this.ubicaciones = ubicaciones;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public boolean isLtr() {
        return ltr;
    }

    public void setLtr(boolean ltr) {
        this.ltr = ltr;
    }

    public boolean isRtl() {
        return rtl;
    }

    public void setRtl(boolean rtl) {
        this.rtl = rtl;
    }

    public boolean isTtb() {
        return ttb;
    }

    public void setTtb(boolean ttb) {
        this.ttb = ttb;
    }

    public boolean isBtt() {
        return btt;
    }

    public void setBtt(boolean btt) {
        this.btt = btt;
    }

    public boolean isD() {
        return d;
    }

    public void setD(boolean d) {
        this.d = d;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public CategoriasPalabras getCategoriasPalabrasByOrdinal(){

        if(CategoriasPalabras.TODAS_LAS_PALABRAS.ordinal() + 1  == this.c){
            return CategoriasPalabras.TODAS_LAS_PALABRAS;
        }else if(CategoriasPalabras.ANIMALES.ordinal() + 1 == this.c){
            return CategoriasPalabras.ANIMALES;
        }else if(CategoriasPalabras.NATURALEZA.ordinal() + 1 == this.c){
            return CategoriasPalabras.NATURALEZA;
        }else if(CategoriasPalabras.FIGURAS.ordinal() + 1 == this.c){
            return CategoriasPalabras.FIGURAS;
        }else if(CategoriasPalabras.HOGAR.ordinal() + 1 == this.c){
            return CategoriasPalabras.HOGAR;
        }else if(CategoriasPalabras.FAMILIA.ordinal() + 1 == this.c){
            return CategoriasPalabras.FAMILIA;
        }else if(CategoriasPalabras.PAISES.ordinal() + 1 == this.c){
            return CategoriasPalabras.PAISES;
        }else if(CategoriasPalabras.CIUDADES.ordinal() + 1 == this.c){
            return CategoriasPalabras.CIUDADES;
        }else if(CategoriasPalabras.DEPORTE.ordinal() + 1 == this.c){
            return CategoriasPalabras.DEPORTE;
        }else if(CategoriasPalabras.PROFESIONES.ordinal() + 1 == this.c){
            return CategoriasPalabras.PROFESIONES;
        }else{
            return CategoriasPalabras.COLORES;
        }
    }

    public SopaDePalabras getSopaDePalabras() {
        return sopaDePalabras;
    }

    public void setSopaDePalabras(SopaDePalabras sopaDePalabras) {
        this.sopaDePalabras = sopaDePalabras;
    }

    public List<Ubicacion> getUbicaciones() {
        return ubicaciones;
    }

    public void setUbicaciones(List<Ubicacion> ubicaciones) {
        this.ubicaciones = ubicaciones;
    }
}
