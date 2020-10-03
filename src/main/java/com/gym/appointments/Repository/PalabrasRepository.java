package com.gym.appointments.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalabrasRepository {

    List<String> todasLasPalabras;
    List<String> animales;
    List<String> naturaleza;
    List<String> figuras;
    List<String> hogar;
    List<String> familia;
    List<String> paises;
    List<String> cuidades;
    List<String> deporte;
    List<String> profesiones;
    List<String> colores;


    public PalabrasRepository() {
    }

    public List<String> getTodasLasPalabras() {
        this.todasLasPalabras = new ArrayList<>(Arrays.asList("oso", "gato", "perro", "leon", "caballo", "cerdo", "jirafa", "cocodrilo", "serpiente", "iguana", "mono", "tigre", "lobo", "jaguar", "leopardo",
                "arbol", "hoja", "tierra", "cielo", "aire", "agua", "vida", "amor", "animales", "lluvia", "sol", "nuves", "nieve", "frio", "calor",
                "cuadrado", "triangulo", "rectangulo", "rombo", "circulo", "linea", "cubo",
                "televisor", "casa", "habitacion", "baño", "cama", "mesa", "silla", "puerta", "ventana", "techo", "piso",
                "madre", "padre", "familia", "hermano", "hermana", "tio", "tia", "primo", "prima", "novio", "novia", "amigo", "amiga",
                "cuba", "españa", "francia", "brazil", "argentina", "uruguay", "chile", "peru", "belgica", "canada", "mexico", "rusia", "holanda", "paraguay", "australia",
                "habana", "santiago", "madrid", "moscu", "otawa", "edmonton", "paris", "valencia", "brasilia", "barcelona", "denver", "quebec", "matanzas", "lion",
                "ciclismo", "atletismo", "football", "baseball", "basket", "tenis", "natacion", "voleibol", "balonmano", "softbol",
                "maestro", "ingeniero", "abogado", "medico", "enfermera", "licenciado", "arquitecto", "musico", "periodista",
                "rojo", "azul", "verde", "amarillo", "rosa", "violeta", "negro", "blanco", "gris"));
        return this.todasLasPalabras;
    }

    public List<String> getAnimales() {
        this.animales = new ArrayList<>(Arrays.asList( "oso", "gato", "perro", "leon", "caballo", "cerdo", "jirafa", "cocodrilo", "serpiente", "iguana", "mono", "tigre", "lobo", "jaguar", "leopardo"));
        return this.animales;
    }

    public List<String> getNaturaleza() {
        this.naturaleza = new ArrayList<>(Arrays.asList( "arbol", "hoja", "tierra", "cielo", "aire", "agua", "vida", "amor", "animales", "lluvia", "sol", "nuves", "nieve", "frio", "calor"));
        return naturaleza;
    }

    public List<String> getFiguras() {
        this.figuras = new ArrayList<>(Arrays.asList( "cuadrado", "triangulo", "rectangulo", "rombo", "circulo", "linea", "cubo"));
        return this.figuras;
    }

    public List<String> getHogar() {
        this.hogar = new ArrayList<>(Arrays.asList( "televisor", "casa", "habitacion", "baño", "cama", "mesa", "silla", "puerta", "ventana", "techo", "piso" ));
        return this.hogar;
    }

    public List<String> getFamilia() {
        this.familia = new ArrayList<>(Arrays.asList( "madre", "padre", "familia", "hermano", "hermana", "tio", "tia", "primo", "prima", "novio", "novia", "amigo", "amiga" ));
        return this.familia;
    }

    public List<String> getPaises() {
        this.paises = new ArrayList<>(Arrays.asList( "cuba", "españa", "francia", "brazil", "argentina", "uruguay", "chile", "peru", "belgica", "canada", "mexico", "rusia", "holanda", "paraguay", "australia"));
        return this.paises;
    }

    public List<String> getCuidades() {
        this.cuidades = new ArrayList<>(Arrays.asList( "habana", "santiago", "madrid", "moscu", "otawa", "edmonton", "paris", "valencia", "brasilia", "barcelona", "denver", "quebec", "matanzas", "lion"));
        return this.cuidades;
    }

    public List<String> getDeporte() {
        this.deporte = new ArrayList<>(Arrays.asList( "ciclismo", "atletismo", "football", "baseball", "basket", "tenis", "natacion", "voleibol", "balonmano", "softbol"));
        return this.deporte;
    }

    public List<String> getProfesiones() {
        this.profesiones = new ArrayList<>(Arrays.asList( "maestro", "ingeniero", "abogado", "medico", "enfermera", "licenciado", "arquitecto", "musico", "periodista"));
        return this.profesiones;
    }

    public List<String> getColores() {
        this.colores = new ArrayList<>(Arrays.asList( "rojo", "azul", "verde", "amarillo", "rosa", "violeta", "negro", "blanco", "gris"));
        return this.colores;
    }

}
