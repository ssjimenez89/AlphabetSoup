package com.gym.appointments.Model;


import javax.validation.constraints.Max;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

public class SopaDePalabras {

    UUID id;
    Character[][] sopaPalabras;
    List<Coordenada> coordenasDePalabras;
    List<Coordenada> coordenasDePalabrasEncontradas;
    List<String> palabras;
    List<String> palabrasEncontradas;


    public SopaDePalabras() {
    }

    public SopaDePalabras(Character[][] sopaPalabras, List<Coordenada> coordenasDePalabras, List<Coordenada> coordenasDePalabrasEncontradas, List<String> palabras, List<String> palabrasEncontradas) {
        this.sopaPalabras = sopaPalabras;
        this.coordenasDePalabras = coordenasDePalabras;
        this.coordenasDePalabrasEncontradas = coordenasDePalabrasEncontradas;
        this.palabras = palabras;
        this.palabrasEncontradas = palabrasEncontradas;
    }

    public Character[][] crearSopaDeLetras(int altura, int ancho) {
        Letras letras = new Letras();

        Character[][] sopaDeLetras = new Character[altura][ancho];
        for (int i = 0; i < sopaDeLetras.length; i++) {
            for (int j = 0; j < sopaDeLetras[i].length; j++) {

                sopaDeLetras[i][j] = letras.letrasRandom();
            }
        }
        return sopaDeLetras;
    }

    public boolean generarSopaDepalabras(int altura, int ancho, List<String> ubicaciones, int categoria) {

        //Generando el id UUID de la Sopa de Palabras
        this.id = UUID.randomUUID();

        //Se Crea la Sopa de Letras!!!
        sopaPalabras = this.crearSopaDeLetras(altura, ancho);

        //Se generan la Palabras a Insertar en la Sopa de Letras!!!
        Palabras p = new Palabras();
        this.palabras = p.palabrasRandom(altura, ancho, categoria);

        //Se Insertan las Palabras en la Sopa de Letras!!!
        this.insertarPalabrasEnSopa(ubicaciones);

        //this.setSopaPalabras(null);
        if(this.getSopaPalabras() != null){

            System.out.println("");
            System.out.println("-------- Generando sopa de palabras con Alto: " + altura + " y Ancho: " + ancho + " ---------");
            System.out.println("");

        //Mostrar la Sopa de Palabras

        System.out.println("-------- Palabras: " + "(" + this.palabras.size() + ")" + " ---------");
        System.out.println("");

        final int[] contPalabras = {0};
        palabras.stream().forEach(it -> {
            System.out.print(it);
            System.out.print(" ");
            contPalabras[0]++;

            if (contPalabras[0] == 5) {
                System.out.println(" ");
                System.out.println(" ");
                contPalabras[0] = 0;
            }

        });
        System.out.println("");
        System.out.println("");

        int count = 0;
        for (int i = 0; i < sopaPalabras.length; i++) {
            for (int j = 0; j < sopaPalabras[i].length; j++) {

                if (count < ancho - 1) {
                    System.out.print(sopaPalabras[i][j] + "|");
                    count++;
                } else {
                    System.out.println(sopaPalabras[i][j] + "|");
                    count = 0;
                }
            }
        }

            System.out.println("");
            System.out.println("----- A continuación se muestran las Coordenadas de las Palabras en la Sopa, para probar de forma rápido el juego realizado -----");
            System.out.println("");
            final int[] contCoordenadas = {0};
            this.coordenasDePalabras.stream().forEach(it -> {
             int coordenadaAlturaInicial = it.getCoordenadaAlturaInicial() +1;
             int coordenadaAnchoInicial = it.getCoordenadaAnchoInicial() +1;
             int coordenadaAlturaFinal = it.getCoordenadaAlturaFinal() +1;
             int coordenadaAnchoFinal = it.getCoordenadaAnchoFinal() +1;
             contCoordenadas[0]++;
                System.out.println(  contCoordenadas[0] + "-" + "(" + coordenadaAlturaInicial+ "," + coordenadaAnchoInicial + ")" + " " + "(" + coordenadaAlturaFinal + "," + coordenadaAnchoFinal + ")");
            });

        return true;

        }else{
            return false;
        }
    }

    public Character[][] insertarPalabrasEnSopa(List<String> ubicaciones) {
        this.coordenasDePalabras = new ArrayList<>();
        this.coordenasDePalabrasEncontradas = new ArrayList<>();
        this.palabrasEncontradas = new ArrayList<>();
        int altura = this.sopaPalabras.length;
        int ancho = this.sopaPalabras[0].length;

        List<String> horizontalIzqDerecha = new ArrayList<>();
        List<String> horizontalDerechaIzq = new ArrayList<>();
        List<String> verticalArribaAbajo = new ArrayList<>();
        List<String> verticalAbajoArriba = new ArrayList<>();
        List<String> diagonalIzqDerecha = new ArrayList<>();
        List<String> diagonalDerechaIzq = new ArrayList<>();
        List<String> diagonalIzqDerechaAbajoArriba = new ArrayList<>();
        List<String> diagonalDerechaIzqArribaAbajo = new ArrayList<>();

        final boolean[] horiIzDe = {true};
        final boolean[] horiDeIz = {true};
        final boolean[] vertArAb = {true};
        final boolean[] vertAbAr = {true};
        final boolean[] diagIzDe = {true};
        final boolean[] diagDeIz = {true};
        final boolean[] diagIzDeAbAr = {true};
        final boolean[] diagDeIzArAb = {true};

        this.palabras.stream().forEach(it -> {

            if ((it.length() <= ancho) && horiIzDe[0] && ubicaciones.get(0).equalsIgnoreCase("Si")) {
                horizontalIzqDerecha.add(it);
                horiIzDe[0] = false;


            } else if (it.length() <= ancho && horiDeIz[0] && ubicaciones.get(1).equalsIgnoreCase("Si")) {
                horizontalDerechaIzq.add(it);
                horiDeIz[0] = false;


            } else if (it.length() <= altura && vertArAb[0] && ubicaciones.get(2).equalsIgnoreCase("Si")) {
                verticalArribaAbajo.add(it);
                vertArAb[0] = false;


            } else if (it.length() <= altura && vertAbAr[0] && ubicaciones.get(3).equalsIgnoreCase("Si")) {
                verticalAbajoArriba.add(it);
                vertAbAr[0] = false;


            } else if (it.length() <= altura && diagIzDe[0] && ubicaciones.get(4).equalsIgnoreCase("Si")) {
                diagonalIzqDerecha.add(it);
                diagIzDe[0] = false;


            } else if (it.length() <= altura && diagDeIz[0] && ubicaciones.get(5).equalsIgnoreCase("Si")) {
                diagonalDerechaIzq.add(it);
                diagDeIz[0] = false;

            } else if (it.length() <= altura && diagIzDeAbAr[0] && ubicaciones.get(6).equalsIgnoreCase("Si")) {
                diagonalIzqDerechaAbajoArriba.add(it);
                diagIzDeAbAr[0] = false;

            } else if (it.length() <= altura && diagDeIzArAb[0] && ubicaciones.get(7).equalsIgnoreCase("Si")) {
                diagonalDerechaIzqArribaAbajo.add(it);
                diagDeIzArAb[0] = false;

            } else {
                horiIzDe[0] = true;
                horiDeIz[0] = true;
                vertArAb[0] = true;
                vertAbAr[0] = true;
                diagIzDe[0] = true;
                diagDeIz[0] = true;
                diagIzDeAbAr[0] = true;
                diagDeIzArAb[0] = true;

                if (horizontalIzqDerecha.size() > 0) {
                    horizontalIzqDerecha.add(it);
                } else if (horizontalDerechaIzq.size() > 0) {
                    horizontalDerechaIzq.add(it);
                } else if (verticalArribaAbajo.size() > 0) {
                    verticalArribaAbajo.add(it);
                } else if (verticalAbajoArriba.size() > 0) {
                    verticalAbajoArriba.add(it);
                } else if (diagonalIzqDerecha.size() > 0) {
                    diagonalIzqDerecha.add(it);
                } else if (diagonalDerechaIzq.size() > 0) {
                    diagonalDerechaIzq.add(it);
                } else if (diagonalIzqDerechaAbajoArriba.size() > 0) {
                    diagonalIzqDerechaAbajoArriba.add(it);
                } else if (diagonalDerechaIzqArribaAbajo.size() > 0) {
                    diagonalDerechaIzqArribaAbajo.add(it);
                }
            }
        });

        // Ubicación Horizontal de Izquierda a Derecha

        List<Integer> listDei = new ArrayList<>();
        //int horizontalSize = horizontal.size();
        while (horizontalIzqDerecha.size() > 0) {
            int cont = 0;
            String palabra = horizontalIzqDerecha.get(cont);
            Coordenada coordenada = new Coordenada();
            coordenada.setUbicacion(Ubicacion.HORIZONTAL_IZQUIERDA_DERECHA);
            List<Par> paresDeLaCoordenada = new ArrayList<>();

            int i = ObtenerI(listDei, altura);
            int j = (int) (Math.random() * (this.sopaPalabras[0].length - palabra.length()));
            listDei.add(i);
            coordenada.setCoordenadaAlturaInicial(i);
            coordenada.setCoordenadaAnchoInicial(j);
            coordenada.setLongitud(palabra.length());

            int contPalabraLength = palabra.length();
            for ( i = i; i < this.sopaPalabras.length; i++) {

                for (j = j; j < this.sopaPalabras[0].length; j++) {

                    if (contPalabraLength > 0) {
                        this.sopaPalabras[i][j] = palabra.charAt((palabra.length() - 1) - (contPalabraLength - 1));
                        Par par = new Par(i, j);
                        paresDeLaCoordenada.add(par);
                        contPalabraLength--;

                    } else {
                        coordenada.setCoordenadaAlturaFinal(i);
                        coordenada.setCoordenadaAnchoFinal(j - 1);
                        coordenada.setPares(paresDeLaCoordenada);
                        this.coordenasDePalabras.add(coordenada);
                        break;
                    }
                }
                break;
            }
            horizontalIzqDerecha.remove(cont);
            cont++;
        }

        // Ubicación Horizontal de Derecha a Izquierda

        List<Integer> listDei1 = new ArrayList<>();
        while (horizontalDerechaIzq.size() > 0) {
            int cont = 0;
            String palabra = horizontalDerechaIzq.get(cont);
            Coordenada coordenada = new Coordenada();
            coordenada.setUbicacion(Ubicacion.HORIZONTAL_DERECHA_IZQUIERDA);
            List<Par> paresDeLaCoordenada = new ArrayList<>();

            boolean coordenadasHorizontalesValidas = true;

            int valorDei1 = ObtenerI(listDei1, altura);
            int j = (int) (Math.random() * (this.sopaPalabras[0].length - palabra.length()) + palabra.length());
            coordenada.setCoordenadaAlturaInicial(valorDei1);
            coordenada.setCoordenadaAnchoInicial(j);
            coordenada.setLongitud(palabra.length());

            coordenadasHorizontalesValidas = comprobarCoordenadasHorizontalesDeDerechaHaciaIzquierda(valorDei1, j, palabra.length());
            while (!coordenadasHorizontalesValidas) {
                valorDei1 = ObtenerI(listDei1, ancho);
                coordenada.setCoordenadaAnchoInicial(valorDei1);
                coordenadasHorizontalesValidas = comprobarCoordenadasHorizontalesDeDerechaHaciaIzquierda(valorDei1, j, palabra.length());
            }
            listDei1.add(valorDei1);

            //if (coordenadasHorizontalesValidas) {
                int contPalabraLength = palabra.length();
                for (int i = valorDei1; i < this.sopaPalabras.length; i++) {

                    for (j = j; j < this.sopaPalabras[0].length; j--) {

                        if (contPalabraLength > 0) {
                            this.sopaPalabras[i][j] = palabra.charAt((palabra.length() - 1) - (contPalabraLength - 1));
                            Par par = new Par(i, j);
                            paresDeLaCoordenada.add(par);
                            contPalabraLength--;

                        } else {
                            coordenada.setCoordenadaAlturaFinal(i);
                            coordenada.setCoordenadaAnchoFinal(j + 1);
                            coordenada.setPares(paresDeLaCoordenada);
                            this.coordenasDePalabras.add(coordenada);
                            break;
                        }
                    }
                    break;
                }
            //}
            horizontalDerechaIzq.remove(cont);
            cont++;
        }

        // Ubicación Vertical de arriba hacia abajo

        List<Integer> listDej = new ArrayList<>();
        //int verticalSize = vertical.size();
        while (verticalArribaAbajo.size() > 0) {
            int cont = 0;
            String palabra = verticalArribaAbajo.get(cont);
            Coordenada coordenada = new Coordenada();
            coordenada.setUbicacion(Ubicacion.VERTICAL_ARRIBA_ABAJO);
            List<Par> paresDeLaCoordenada = new ArrayList<>();

            boolean coordenadasVerticalesValidas = true;

            int valorDej = ObtenerI(listDej, ancho);
            int i = (int) (Math.random() * (this.sopaPalabras.length - palabra.length()));
            coordenada.setCoordenadaAlturaInicial(i);
            coordenada.setCoordenadaAnchoInicial(valorDej);
            coordenada.setLongitud(palabra.length());

            coordenadasVerticalesValidas = comprobarCoordenadasVerticalesDeArribaHaciaAbajo(i, valorDej, palabra.length(), this.sopaPalabras.length);
            boolean temp = true;
            while (!coordenadasVerticalesValidas && temp) {
                valorDej = ObtenerI(listDej, altura);
                coordenada.setCoordenadaAlturaInicial(valorDej);
                coordenadasVerticalesValidas = comprobarCoordenadasVerticalesDeArribaHaciaAbajo(i++, valorDej, palabra.length(), this.sopaPalabras.length);
                coordenada.setCoordenadaAnchoInicial(i);
                if (i == this.sopaPalabras.length - palabra.length()) {
                    temp = false;
                }
            }
            listDej.add(valorDej);

            if (coordenadasVerticalesValidas) {
                boolean termino = false;
                int contPalabraLength = palabra.length();
                for (i = i; i < this.sopaPalabras.length; i++) {

                    for (int j = valorDej; j < this.sopaPalabras[0].length; j++) {

                        if (contPalabraLength > 0) {
                            this.sopaPalabras[i][j] = palabra.charAt((palabra.length() - 1) - (contPalabraLength - 1));
                            Par par = new Par(i, j);
                            paresDeLaCoordenada.add(par);
                            contPalabraLength--;
                            break;
                        } else {
                            coordenada.setCoordenadaAlturaFinal(i - 1);
                            coordenada.setCoordenadaAnchoFinal(j);
                            coordenada.setPares(paresDeLaCoordenada);
                            this.coordenasDePalabras.add(coordenada);
                            termino = true;
                            break;
                        }
                    }
                    if (termino) {
                        break;
                    }
                }
            }
            verticalArribaAbajo.remove(cont);
            cont++;
        }

        // Ubicación Vertical de abajo hacia arriba

        List<Integer> listDej1 = new ArrayList<>();
        while (verticalAbajoArriba.size() > 0) {
            int cont = 0;
            String palabra = verticalAbajoArriba.get(cont);
            Coordenada coordenada = new Coordenada();
            coordenada.setUbicacion(Ubicacion.VERTICAL_ABAJO_ARRIBA);
            List<Par> paresDeLaCoordenada = new ArrayList<>();

            boolean coordenadasVerticalesValidas = true;

            int valorDej = ObtenerI(listDej1, ancho);
            int i = (int) (Math.random() * (this.sopaPalabras.length - palabra.length()) + palabra.length());
            coordenada.setCoordenadaAlturaInicial(i);
            coordenada.setCoordenadaAnchoInicial(valorDej);
            coordenada.setLongitud(palabra.length());

            coordenadasVerticalesValidas = comprobarCoordenadasVerticalesDeAbajoHaciaArriba(i, valorDej, palabra.length());
            while (!coordenadasVerticalesValidas) {
                valorDej = ObtenerI(listDej1, altura);
                coordenada.setCoordenadaAnchoInicial(valorDej);
                coordenadasVerticalesValidas = comprobarCoordenadasVerticalesDeAbajoHaciaArriba(i, valorDej, palabra.length());
            }
            listDej1.add(valorDej);

            boolean termino = false;
            int contPalabraLength = palabra.length();
            for (i = i; i >= 0; i--) {

                for (int j = valorDej; j < this.sopaPalabras[0].length; j++) {

                    if (contPalabraLength > 0) {
                        this.sopaPalabras[i][j] = palabra.charAt((palabra.length() - 1) - (contPalabraLength - 1));
                        Par par = new Par(i, j);
                        paresDeLaCoordenada.add(par);
                        contPalabraLength--;
                        break;
                    } else {
                        coordenada.setCoordenadaAlturaFinal(i + 1);
                        coordenada.setCoordenadaAnchoFinal(j);
                        coordenada.setPares(paresDeLaCoordenada);
                        this.coordenasDePalabras.add(coordenada);
                        termino = true;
                        break;
                    }
                }
                if (termino) {
                    break;
                }
            }
            verticalAbajoArriba.remove(cont);
            cont++;
        }

        // Ubicación Diagonal de Iquierda a Derecha de Arriba hacia Abajo

        while (diagonalIzqDerecha.size() > 0) {
            int cont = 0;
            String palabra = diagonalIzqDerecha.get(cont);
            Coordenada coordenada = new Coordenada();
            coordenada.setUbicacion(Ubicacion.DIAGONAL_IZQUIERDA_DERECHA_ARRIBA_ABAJO);
            List<Par> paresDeLaCoordenada = new ArrayList<>();
            boolean coordenadasDiagonalValidas = true;

            int i = (int) (Math.random() * (this.sopaPalabras.length - palabra.length()));
            int j = (int) (Math.random() * (this.sopaPalabras[0].length - palabra.length()));
            coordenada.setCoordenadaAlturaInicial(i);
            coordenada.setCoordenadaAnchoInicial(j);
            coordenada.setLongitud(palabra.length());

            coordenadasDiagonalValidas = comprobarCoordenadasDiagonalIzqDerecha(i, j, palabra.length(), this.sopaPalabras.length);
            boolean temp = true;
            while (!coordenadasDiagonalValidas && temp) {
                i = (int) (Math.random() * (this.sopaPalabras.length - palabra.length()));
                j = (int) (Math.random() * (this.sopaPalabras[0].length - palabra.length()));
                coordenadasDiagonalValidas = comprobarCoordenadasDiagonalIzqDerecha(i, j, palabra.length(),  this.sopaPalabras.length);
                coordenada.setCoordenadaAlturaInicial(i);
                coordenada.setCoordenadaAnchoInicial(j);
                /*if(i == this.sopaPalabras.length - palabra.length()){
                    temp = false;
                }*/
            }

            if (coordenadasDiagonalValidas) {
                boolean termino = false;
                int contPalabraLength = palabra.length();
                for (i = i; i < this.sopaPalabras.length; i++) {

                    for (j = j; j < this.sopaPalabras[0].length; j++) {

                        if (contPalabraLength > 0) {
                            this.sopaPalabras[i][j] = palabra.charAt((palabra.length() - 1) - (contPalabraLength - 1));
                            Par par = new Par(i, j);
                            paresDeLaCoordenada.add(par);
                            contPalabraLength--;
                            j++;
                            break;
                        } else {
                            coordenada.setCoordenadaAlturaFinal(i - 1);
                            coordenada.setCoordenadaAnchoFinal(j - 1);
                            coordenada.setPares(paresDeLaCoordenada);
                            this.coordenasDePalabras.add(coordenada);
                            termino = true;
                            break;
                        }
                    }
                    if (termino) {
                        break;
                    }
                }
            }
            diagonalIzqDerecha.remove(cont);
            cont++;
        }

        // Ubicación Diagonal de Derecha a Izquierda de Abajo hacia Arriba

        while (diagonalDerechaIzq.size() > 0) {
            int cont = 0;
            String palabra = diagonalDerechaIzq.get(cont);
            Coordenada coordenada = new Coordenada();
            coordenada.setUbicacion(Ubicacion.DIAGONAL_DERECHA_IZQUIERDA_ABAJO_ARRIBA);
            List<Par> paresDeLaCoordenada = new ArrayList<>();
            boolean coordenadasDiagonalValidas = true;

            int i = (int) (Math.random() * (this.sopaPalabras.length - palabra.length()) + palabra.length());
            int j = (int) (Math.random() * (this.sopaPalabras[0].length - palabra.length()) + palabra.length());
            coordenada.setCoordenadaAlturaInicial(i);
            coordenada.setCoordenadaAnchoInicial(j);
            coordenada.setLongitud(palabra.length());

            coordenadasDiagonalValidas = comprobarCoordenadasDiagonalDerechaIzq(i, j, palabra.length(), this.sopaPalabras.length);
            boolean temp = true;
            while (!coordenadasDiagonalValidas && temp) {
                i = (int) (Math.random() * (this.sopaPalabras.length - palabra.length()) + palabra.length());
                j = (int) (Math.random() * (this.sopaPalabras[0].length - palabra.length()) + palabra.length());
                coordenadasDiagonalValidas = comprobarCoordenadasDiagonalDerechaIzq(i, j, palabra.length(), this.sopaPalabras.length);
                coordenada.setCoordenadaAlturaInicial(i);
                coordenada.setCoordenadaAnchoInicial(j);
               /* if(i == palabra.length()){
                    temp = false;
                }*/
            }

            if (coordenadasDiagonalValidas) {
                boolean termino = false;
                int contPalabraLength = palabra.length();
                for (i = i; i < this.sopaPalabras.length; i--) {

                    for (j = j; i < this.sopaPalabras[0].length; j--) {

                        if (contPalabraLength > 0) {
                            this.sopaPalabras[i][j] = palabra.charAt((palabra.length() - 1) - (contPalabraLength - 1));
                            Par par = new Par(i, j);
                            paresDeLaCoordenada.add(par);
                            contPalabraLength--;
                            j--;
                            break;
                        } else {
                            coordenada.setCoordenadaAlturaFinal(i + 1);
                            coordenada.setCoordenadaAnchoFinal(j + 1);
                            coordenada.setPares(paresDeLaCoordenada);
                            this.coordenasDePalabras.add(coordenada);
                            termino = true;
                            break;
                        }
                    }
                    if (termino) {
                        break;
                    }
                }
            }
            diagonalDerechaIzq.remove(cont);
            cont++;
        }

        // Ubicación Diagonal de Iquierda a Derecha de Abajo hacia Arriba

        while (diagonalIzqDerechaAbajoArriba.size() > 0) {
            int cont = 0;
            String palabra = diagonalIzqDerechaAbajoArriba.get(cont);
            Coordenada coordenada = new Coordenada();
            coordenada.setUbicacion(Ubicacion.DIAGONAL_IZQUIERDA_DERECHA_ABAJO_ARRIBA);
            List<Par> paresDeLaCoordenada = new ArrayList<>();
            boolean coordenadasDiagonalValidas = true;

            int i = (int) (Math.random() * (this.sopaPalabras.length - palabra.length()) + palabra.length());
            int j = (int) (Math.random() * (this.sopaPalabras[0].length - palabra.length()));
            coordenada.setCoordenadaAlturaInicial(i);
            coordenada.setCoordenadaAnchoInicial(j);
            coordenada.setLongitud(palabra.length());

            coordenadasDiagonalValidas = comprobarCoordenadasDiagonalIzqDerechaAbajoArriba(i, j, palabra.length(), this.sopaPalabras.length);
            boolean temp = true;
            while (!coordenadasDiagonalValidas && temp) {
                i = (int) (Math.random() * (this.sopaPalabras.length - palabra.length()) + palabra.length());
                j = (int) (Math.random() * (this.sopaPalabras[0].length - palabra.length()));
                coordenadasDiagonalValidas = comprobarCoordenadasDiagonalIzqDerechaAbajoArriba(i, j, palabra.length(),  this.sopaPalabras.length);
                coordenada.setCoordenadaAlturaInicial(i);
                coordenada.setCoordenadaAnchoInicial(j);
                /*if(i == this.sopaPalabras.length - palabra.length()){
                    temp = false;
                }*/
            }

            if (coordenadasDiagonalValidas) {
                boolean termino = false;
                int contPalabraLength = palabra.length();
                for (i = i; i < this.sopaPalabras.length; i--) {

                    for (j = j; j < this.sopaPalabras[0].length; j++) {

                        if (contPalabraLength > 0) {
                            this.sopaPalabras[i][j] = palabra.charAt((palabra.length() - 1) - (contPalabraLength - 1));
                            Par par = new Par(i, j);
                            paresDeLaCoordenada.add(par);
                            contPalabraLength--;
                            j++;
                            break;
                        } else {
                            coordenada.setCoordenadaAlturaFinal(i + 1);
                            coordenada.setCoordenadaAnchoFinal(j - 1);
                            coordenada.setPares(paresDeLaCoordenada);
                            this.coordenasDePalabras.add(coordenada);
                            termino = true;
                            break;
                        }
                    }
                    if (termino) {
                        break;
                    }
                }
            }
            diagonalIzqDerechaAbajoArriba.remove(cont);
            cont++;
        }

        // Ubicación Diagonal de Derecha a Izquierda de Arriba hacia Abajo

        while (diagonalDerechaIzqArribaAbajo.size() > 0) {
            int cont = 0;
            String palabra = diagonalDerechaIzqArribaAbajo.get(cont);
            Coordenada coordenada = new Coordenada();
            coordenada.setUbicacion(Ubicacion.DIAGONAL_DERECHA_IZQUIERDA_ARRIBA_ABAJO);
            List<Par> paresDeLaCoordenada = new ArrayList<>();
            boolean coordenadasDiagonalValidas = true;

            int i = (int) (Math.random() * (this.sopaPalabras.length - palabra.length()));
            int j = (int) (Math.random() * (this.sopaPalabras[0].length - palabra.length()) + palabra.length());

            coordenada.setCoordenadaAlturaInicial(i);
            coordenada.setCoordenadaAnchoInicial(j);
            coordenada.setLongitud(palabra.length());

            coordenadasDiagonalValidas = comprobarCoordenadasDiagonalDerechaIzqArribaAbajo(i, j, palabra.length(), this.sopaPalabras.length);
            boolean temp = true;
            while (!coordenadasDiagonalValidas && temp) {
                i = (int) (Math.random() * (this.sopaPalabras.length - palabra.length()));
                j = (int) (Math.random() * (this.sopaPalabras[0].length - palabra.length()) + palabra.length());
                coordenadasDiagonalValidas = comprobarCoordenadasDiagonalDerechaIzqArribaAbajo(i, j, palabra.length(), this.sopaPalabras.length);
                coordenada.setCoordenadaAlturaInicial(i);
                coordenada.setCoordenadaAnchoInicial(j);
               /* if(i == palabra.length()){
                    temp = false;
                }*/
            }

            if (coordenadasDiagonalValidas) {
                boolean termino = false;
                int contPalabraLength = palabra.length();
                for (i = i; i < this.sopaPalabras.length; i++) {

                    for (j = j; i < this.sopaPalabras[0].length; j--) {

                        if (contPalabraLength > 0) {
                            this.sopaPalabras[i][j] = palabra.charAt((palabra.length() - 1) - (contPalabraLength - 1));
                            Par par = new Par(i, j);
                            paresDeLaCoordenada.add(par);
                            contPalabraLength--;
                            j--;
                            break;
                        } else {
                            coordenada.setCoordenadaAlturaFinal(i - 1);
                            coordenada.setCoordenadaAnchoFinal(j + 1);
                            coordenada.setPares(paresDeLaCoordenada);
                            this.coordenasDePalabras.add(coordenada);
                            termino = true;
                            break;
                        }
                    }
                    if (termino) {
                        break;
                    }
                }
            }
            diagonalDerechaIzqArribaAbajo.remove(cont);
            cont++;
        }

        return this.sopaPalabras;
    }

    public boolean comprobarCoordenadasHorizontalesDeDerechaHaciaIzquierda(int i, int j, int length) {
        final boolean[] coordenadasValidas = {true};
        int cont = length;
        List<Par> parList = new ArrayList<>();

        while (cont > 0) {
            Par par = new Par(i, j);
            parList.add(par);
            j--;
            cont--;
        }

        this.coordenasDePalabras.stream().forEach(it -> {
            List<Par> listComprobar = it.getPares();

            if (listComprobar != null) {
                parList.stream().forEach(it1 -> {

                    listComprobar.stream().map(it2 -> {
                        if (it1.getParInicial() == it2.getParInicial() && it1.getParFinal() == it2.getParFinal()) {
                            coordenadasValidas[0] = false;
                        }
                        return it2;
                    }).collect(Collectors.toList());

                });
            }

        });

        return coordenadasValidas[0];
    }

    public boolean comprobarCoordenadasVerticalesDeArribaHaciaAbajo(int i, int j, int length, int ancho) {
        final boolean[] coordenadasValidas = {true};
        if (ancho > i + length) {
            int cont = length;
            List<Par> parList = new ArrayList<>();

            while (cont > 0) {
                Par par = new Par(i, j);
                parList.add(par);
                i++;
                cont--;
            }

            this.coordenasDePalabras.stream().forEach(it -> {
                List<Par> listComprobar = it.getPares();

                if (listComprobar != null) {
                    parList.stream().forEach(it1 -> {

                        listComprobar.stream().map(it2 -> {
                            if (it1.getParInicial() == it2.getParInicial() && it1.getParFinal() == it2.getParFinal()) {
                                coordenadasValidas[0] = false;
                            }
                            return it2;
                        }).collect(Collectors.toList());

                    });
                }

            });

            return coordenadasValidas[0];
        }
        return false;

    }

    public boolean comprobarCoordenadasVerticalesDeAbajoHaciaArriba(int i, int j, int length) {
        final boolean[] coordenadasValidas = {true};
        int cont = length;
        List<Par> parList = new ArrayList<>();

        while (cont > 0) {
            Par par = new Par(i, j);
            parList.add(par);
            i--;
            cont--;
        }

        this.coordenasDePalabras.stream().forEach(it -> {
            List<Par> listComprobar = it.getPares();

            if (listComprobar != null) {
                parList.stream().forEach(it1 -> {

                    listComprobar.stream().map(it2 -> {
                        if (it1.getParInicial() == it2.getParInicial() && it1.getParFinal() == it2.getParFinal()) {
                            coordenadasValidas[0] = false;
                        }
                        return it2;
                    }).collect(Collectors.toList());

                });
            }

        });

        return coordenadasValidas[0];
    }

    public boolean comprobarCoordenadasDiagonalIzqDerecha(int i, int j, int length, int ancho) {
        final boolean[] coordenadasValidas = {true};
        if (ancho > i + length) {
            int cont = length;
            List<Par> parList = new ArrayList<>();

            while (cont > 0) {
                Par par = new Par(i, j);
                parList.add(par);
                i++;
                j++;
                cont--;
            }

            this.coordenasDePalabras.stream().forEach(it -> {
                List<Par> listComprobar = it.getPares();

                if (listComprobar != null) {
                    parList.stream().forEach(it1 -> {

                        listComprobar.stream().forEach(it2 -> {
                            if (it1.getParInicial() == it2.getParInicial() && it1.getParFinal() == it2.getParFinal()) {
                                coordenadasValidas[0] = false;

                            }

                        });

                    });
                }

            });
            return coordenadasValidas[0];
        }
        return false;
    }

    public boolean comprobarCoordenadasDiagonalDerechaIzq(int i, int j, int length, int ancho) {
        final boolean[] coordenadasValidas = {true};
        if (i >= length - 1) {
            int cont = length;
            List<Par> parList = new ArrayList<>();

            while (cont > 0) {
                Par par = new Par(i, j);
                parList.add(par);
                i--;
                j--;
                cont--;
            }

            this.coordenasDePalabras.stream().forEach(it -> {
                List<Par> listComprobar = it.getPares();

                if (listComprobar != null) {
                    parList.stream().forEach(it1 -> {

                        listComprobar.stream().forEach(it2 -> {
                            if (it1.getParInicial() == it2.getParInicial() && it1.getParFinal() == it2.getParFinal()) {
                                coordenadasValidas[0] = false;

                            }

                        });

                    });
                }

            });
            return coordenadasValidas[0];
        }
        return false;
    }

    public boolean comprobarCoordenadasDiagonalIzqDerechaAbajoArriba(int i, int j, int length, int ancho) {
        final boolean[] coordenadasValidas = {true};
        if (i >= length - 1) {
            int cont = length;
            List<Par> parList = new ArrayList<>();

            while (cont > 0) {
                Par par = new Par(i, j);
                parList.add(par);
                i--;
                j++;
                cont--;
            }

            this.coordenasDePalabras.stream().forEach(it -> {
                List<Par> listComprobar = it.getPares();

                if (listComprobar != null) {
                    parList.stream().forEach(it1 -> {

                        listComprobar.stream().forEach(it2 -> {
                            if (it1.getParInicial() == it2.getParInicial() && it1.getParFinal() == it2.getParFinal()) {
                                coordenadasValidas[0] = false;

                            }

                        });

                    });
                }

            });
            return coordenadasValidas[0];
        }
        return false;
    }

    public boolean comprobarCoordenadasDiagonalDerechaIzqArribaAbajo(int i, int j, int length, int ancho) {
        final boolean[] coordenadasValidas = {true};
        if (j >= length - 1) {
            int cont = length;
            List<Par> parList = new ArrayList<>();

            while (cont > 0) {
                Par par = new Par(i, j);
                parList.add(par);
                i++;
                j--;
                cont--;
            }

            this.coordenasDePalabras.stream().forEach(it -> {
                List<Par> listComprobar = it.getPares();

                if (listComprobar != null) {
                    parList.stream().forEach(it1 -> {

                        listComprobar.stream().forEach(it2 -> {
                            if (it1.getParInicial() == it2.getParInicial() && it1.getParFinal() == it2.getParFinal()) {
                                coordenadasValidas[0] = false;

                            }

                        });

                    });
                }

            });
            return coordenadasValidas[0];
        }
        return false;
    }

    public int ObtenerI(List<Integer> list, int factor) {
        int i = (int) (Math.random() * factor);
        final int[] cont = {0};

        list.stream().forEach(it -> {
            if (i == it) {
                cont[0]++;
            }

        });
        if (cont[0] > 0) {
            ObtenerI(list, factor);
            cont[0] = 0;
        } else {
            return i;
        }
        return ObtenerI(list, factor);
    }

    public boolean encontrarPalabraEnSopa(int coordenadaAlturaInicial, int coordenadaAnchoInicial, int coordenadaAlturaFinal, int coordenadaAnchoFinal) {
        final boolean[] coordenadasValidas = {false};
        final boolean[] coordenadasEncontradas = {false};
        this.coordenasDePalabrasEncontradas.forEach(it -> {
            if(it.getCoordenadaAlturaInicial() == coordenadaAlturaInicial && it.getCoordenadaAnchoInicial() == coordenadaAnchoInicial && it.getCoordenadaAlturaFinal() == coordenadaAlturaFinal && it.getCoordenadaAnchoFinal() == coordenadaAnchoFinal){
                coordenadasEncontradas[0] = true;
            }
        });
        if(!coordenadasEncontradas[0]) {
            this.coordenasDePalabras.stream().forEach(it -> {
                if (it.getCoordenadaAlturaInicial() == coordenadaAlturaInicial && it.getCoordenadaAnchoInicial() == coordenadaAnchoInicial && it.getCoordenadaAlturaFinal() == coordenadaAlturaFinal && it.getCoordenadaAnchoFinal() == coordenadaAnchoFinal) {

                    coordenadasValidas[0] = true;
                    Coordenada coordenada = new Coordenada();
                    coordenada.setCoordenadaAlturaInicial(coordenadaAlturaInicial);
                    coordenada.setCoordenadaAnchoInicial(coordenadaAnchoInicial);
                    coordenada.setCoordenadaAlturaFinal(coordenadaAlturaFinal);
                    coordenada.setCoordenadaAnchoFinal(coordenadaAnchoFinal);
                    this.coordenasDePalabrasEncontradas.add(coordenada);

                    if (it.getUbicacion() == Ubicacion.HORIZONTAL_IZQUIERDA_DERECHA) {

                        int contPalabraLength = it.getLongitud();
                        String palabra = "";
                        for (int i = coordenadaAlturaInicial; i < this.sopaPalabras.length; i++) {
                            for (int j = coordenadaAnchoInicial; j < this.sopaPalabras[0].length; j++) {

                                if (contPalabraLength > 0) {
                                    Character ch = this.sopaPalabras[i][j];
                                    palabra = palabra + ch;
                                    ch = Character.toUpperCase(ch);
                                    this.sopaPalabras[i][j] = ch;
                                    contPalabraLength--;
                                } else {
                                    this.palabrasEncontradas.add(palabra);
                                    break;
                                }
                            }
                            break;
                        }

                    } else if (it.getUbicacion() == Ubicacion.HORIZONTAL_DERECHA_IZQUIERDA) {

                        int contPalabraLength = it.getLongitud();
                        String palabra = "";
                        for (int i = coordenadaAlturaInicial; i < this.sopaPalabras.length; i++) {
                            for (int j = coordenadaAnchoInicial; j < this.sopaPalabras[0].length; j--) {

                                if (contPalabraLength > 0) {
                                    Character ch = this.sopaPalabras[i][j];
                                    palabra = palabra + ch;
                                    ch = Character.toUpperCase(ch);
                                    this.sopaPalabras[i][j] = ch;
                                    contPalabraLength--;
                                } else {
                                    this.palabrasEncontradas.add(palabra);
                                    break;
                                }
                            }
                            break;
                        }


                    } else if (it.getUbicacion() == Ubicacion.VERTICAL_ARRIBA_ABAJO) {

                        boolean termino = false;
                        int contPalabraLength = it.getLongitud();
                        String palabra = "";
                        for (int i = coordenadaAlturaInicial; i < this.sopaPalabras.length; i++) {
                            for (int j = coordenadaAnchoInicial; j < this.sopaPalabras[0].length; j++) {

                                if (contPalabraLength > 0) {
                                    Character ch = this.sopaPalabras[i][j];
                                    palabra = palabra + ch;
                                    ch = Character.toUpperCase(ch);
                                    this.sopaPalabras[i][j] = ch;
                                    contPalabraLength--;
                                    break;
                                } else {
                                    this.palabrasEncontradas.add(palabra);
                                    termino = true;
                                    break;
                                }
                            }
                            if (termino) {
                                break;
                            }
                        }


                    } else if (it.getUbicacion() == Ubicacion.VERTICAL_ABAJO_ARRIBA) {

                        boolean termino = false;
                        int contPalabraLength = it.getLongitud();
                        String palabra = "";
                        for (int i = coordenadaAlturaInicial; i < this.sopaPalabras.length; i--) {
                            for (int j = coordenadaAnchoInicial; j < this.sopaPalabras[0].length; j++) {

                                if (contPalabraLength > 0) {
                                    Character ch = this.sopaPalabras[i][j];
                                    palabra = palabra + ch;
                                    ch = Character.toUpperCase(ch);
                                    this.sopaPalabras[i][j] = ch;
                                    contPalabraLength--;
                                    break;
                                } else {
                                    this.palabrasEncontradas.add(palabra);
                                    termino = true;
                                    break;
                                }
                            }
                            if (termino) {
                                break;
                            }
                        }

                    } else if (it.getUbicacion() == Ubicacion.DIAGONAL_IZQUIERDA_DERECHA_ARRIBA_ABAJO) {

                        boolean termino = false;
                        int contPalabraLength = it.getLongitud();
                        String palabra = "";
                        int j = coordenadaAnchoInicial;
                        for (int i = coordenadaAlturaInicial; i < this.sopaPalabras.length; i++) {
                            for (j = j; j < this.sopaPalabras[0].length; j++) {

                                if (contPalabraLength > 0) {
                                    Character ch = this.sopaPalabras[i][j];
                                    palabra = palabra + ch;
                                    ch = Character.toUpperCase(ch);
                                    this.sopaPalabras[i][j] = ch;
                                    contPalabraLength--;
                                    j++;
                                    break;
                                } else {
                                    this.palabrasEncontradas.add(palabra);
                                    termino = true;
                                    break;
                                }
                            }
                            if (termino) {
                                break;
                            }
                        }

                    } else if (it.getUbicacion() == Ubicacion.DIAGONAL_DERECHA_IZQUIERDA_ABAJO_ARRIBA) {
                        //Ubicacion.DIAGONAL_DERECHA_IZQ

                        boolean termino = false;
                        int contPalabraLength = it.getLongitud();
                        String palabra = "";
                        int j = coordenadaAnchoInicial;
                        for (int i = coordenadaAlturaInicial; i < this.sopaPalabras.length; i--) {
                            for (j = j; j < this.sopaPalabras[0].length; j--) {

                                if (contPalabraLength > 0) {
                                    Character ch = this.sopaPalabras[i][j];
                                    palabra = palabra + ch;
                                    ch = Character.toUpperCase(ch);
                                    this.sopaPalabras[i][j] = ch;
                                    contPalabraLength--;
                                    j--;
                                    break;
                                } else {
                                    this.palabrasEncontradas.add(palabra);
                                    termino = true;
                                    break;
                                }
                            }
                            if (termino) {
                                break;
                            }
                        }
                    } else if (it.getUbicacion() == Ubicacion.DIAGONAL_IZQUIERDA_DERECHA_ABAJO_ARRIBA) {

                        boolean termino = false;
                        int contPalabraLength = it.getLongitud();
                        String palabra = "";
                        int j = coordenadaAnchoInicial;
                        for (int i = coordenadaAlturaInicial; i < this.sopaPalabras.length; i--) {
                            for (j = j; j < this.sopaPalabras[0].length; j++) {

                                if (contPalabraLength > 0) {
                                    Character ch = this.sopaPalabras[i][j];
                                    palabra = palabra + ch;
                                    ch = Character.toUpperCase(ch);
                                    this.sopaPalabras[i][j] = ch;
                                    contPalabraLength--;
                                    j++;
                                    break;
                                } else {
                                    this.palabrasEncontradas.add(palabra);
                                    termino = true;
                                    break;
                                }
                            }
                            if (termino) {
                                break;
                            }
                        }
                    } else if (it.getUbicacion() == Ubicacion.DIAGONAL_DERECHA_IZQUIERDA_ARRIBA_ABAJO) {

                        boolean termino = false;
                        int contPalabraLength = it.getLongitud();
                        String palabra = "";
                        int j = coordenadaAnchoInicial;
                        for (int i = coordenadaAlturaInicial; i < this.sopaPalabras.length; i++) {
                            for (j = j; j < this.sopaPalabras[0].length; j--) {

                                if (contPalabraLength > 0) {
                                    Character ch = this.sopaPalabras[i][j];
                                    palabra = palabra + ch;
                                    ch = Character.toUpperCase(ch);
                                    this.sopaPalabras[i][j] = ch;
                                    contPalabraLength--;
                                    j--;
                                    break;
                                } else {
                                    this.palabrasEncontradas.add(palabra);
                                    termino = true;
                                    break;
                                }
                            }
                            if (termino) {
                                break;
                            }
                        }
                    }
                }
            });

            if (coordenadasValidas[0]) {
                //Mostrar la Sopa de Palabras
                System.out.println("");
                System.out.println("-------- Palabras: " + "(" + (this.palabras.size() - this.palabrasEncontradas.size()) + ")" + " ---------");
                System.out.println("");

                final int[] contPalabras = {0};
                final boolean[] palabraEncontrada = {false};
                this.palabras.stream().forEach(it -> {
                    this.palabrasEncontradas.stream().forEach(it1 -> {
                        if (it.equals(it1)) {
                            palabraEncontrada[0] = true;
                        }
                    });

                    if (!palabraEncontrada[0]) {
                        System.out.print(it);
                        System.out.print(" ");
                        contPalabras[0]++;

                        if (contPalabras[0] == 5) {
                            System.out.println(" ");
                            System.out.println(" ");
                            contPalabras[0] = 0;
                        }
                    } else {
                        palabraEncontrada[0] = false;
                    }
                });

                System.out.println("");
                System.out.println("");
                System.out.println("-------- Palabras encontradas: " + this.palabrasEncontradas.size() + " / " + this.palabras.size() + "---------");
                System.out.println("");

                final int[] contPalabrasEncontradas = {0};
                this.palabrasEncontradas.stream().forEach(it -> {

                    System.out.print(it);
                    System.out.print(" ");
                    contPalabrasEncontradas[0]++;

                    if (contPalabras[0] == 5) {
                        System.out.println(" ");
                        System.out.println(" ");
                        contPalabras[0] = 0;
                    }
                });

                System.out.println("");
                System.out.println("");

                int count = 0;
                for (int i = 0; i < sopaPalabras.length; i++) {
                    for (int j = 0; j < sopaPalabras[i].length; j++) {

                        if (count < sopaPalabras[i].length - 1) {
                            System.out.print(sopaPalabras[i][j] + "|");
                            count++;
                        } else {
                            System.out.println(sopaPalabras[i][j] + "|");
                            count = 0;
                        }
                    }
                }

                System.out.println("");
                System.out.println("----- A continuación se muestran las Coordenadas que aún no han sido encontradas para probar de forma rápido el juego realizado -----");
                System.out.println("");
                final int[] contCoordenadas = {0};
                final boolean[] coordEncontradas = {false};
                this.coordenasDePalabras.stream().forEach(it -> {
                    this.coordenasDePalabrasEncontradas.stream().forEach(it1 -> {
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
                       System.out.println(  contCoordenadas[0] + "-" + "(" + coordAlturaInicial+ "," + coordAnchoInicial + ")" + " " + "(" + coordAlturaFinal + "," + coordAnchoFinal + ")");
                    }else{
                        int coordAlturaInicial = it.getCoordenadaAlturaInicial() +1;
                        int coordAnchoInicial = it.getCoordenadaAnchoInicial() +1;
                        int coordAlturaFinal = it.getCoordenadaAlturaFinal() +1;
                        int coordAnchoFinal = it.getCoordenadaAnchoFinal() +1;
                        contCoordenadas[0]++;
                        System.out.println(  contCoordenadas[0] + "-" + "(" + coordAlturaInicial+ "," + coordAnchoInicial + ")" + " " + "(" + coordAlturaFinal + "," + coordAnchoFinal + ")" + " !!!Coordenada encontrada!!! ");
                        coordEncontradas[0] = false;
                    }
                });
                return coordenadasValidas[0];
            } else {
                System.out.println("");
                System.out.print("Las Coordenadas Ingresadas son Inválidas.");
                System.out.println("");
                return coordenadasValidas[0];
            }

        }else{
            System.out.println("");
            System.out.print("Las Coordenadas Ingresadas ya han sido Econtradas anteriormente.");
            System.out.println("");
            return coordenadasValidas[0];
        }

    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Character[][] getSopaPalabras() {
        return sopaPalabras;
    }

    public void setSopaPalabras(Character[][] sopaPalabras) {
        this.sopaPalabras = sopaPalabras;
    }

    public List<Coordenada> getCoordenasDePalabras() {
        return coordenasDePalabras;
    }

    public void setCoordenasDePalabras(List<Coordenada> coordenasDePalabras) {
        this.coordenasDePalabras = coordenasDePalabras;
    }

    public List<Coordenada> getCoordenasDePalabrasEncontradas() {
        return coordenasDePalabrasEncontradas;
    }

    public void setCoordenasDePalabrasEncontradas(List<Coordenada> coordenasDePalabrasEncontradas) {
        this.coordenasDePalabrasEncontradas = coordenasDePalabrasEncontradas;
    }

    public List<String> getPalabras() {
        return palabras;
    }

    public void setPalabras(List<String> palabras) {
        this.palabras = palabras;
    }

    public List<String> getPalabrasEncontradas() {
        return palabrasEncontradas;
    }

    public void setPalabrasEncontradas(List<String> palabrasEncontradas) {
        this.palabrasEncontradas = palabrasEncontradas;
    }
}
