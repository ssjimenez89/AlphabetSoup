package com.gym.appointments;

import com.gym.appointments.Model.Coordenada;
import com.gym.appointments.Model.Letras;
import com.gym.appointments.Model.Palabras;
import com.gym.appointments.Model.SopaDePalabras;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.lang.System.out;

@SpringBootApplication
public class AppointmentsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppointmentsApplication.class, args);

        Scanner entrada = new Scanner(System.in);
        entrada = new Scanner(System.in);

        int parAlturaInicial;
        int parAnchoInicial;

        int parAlturaFinal;
        int parAnchoFinal;

        System.out.println("");
        System.out.println("Bienvenido a la Sopa de Palabras!!!");
        System.out.println("");

        System.out.println("Antes de comenzar a jugar es importante conocer lo siguiente:");
        System.out.println("");
        System.out.println("Para especificar las Filas y las Columnas de la sopa de palabras se debe comenzar a partir de 1 como se muestra a continuación: ");
        System.out.println("");

        System.out.println("        ---Columnas---       ");
        System.out.println(" 1|2|3|4|5|6|7|8|9|10| ... |n|");
        System.out.println(" 2| '");System.out.println(" 3| '");System.out.println(" 4| F");System.out.println(" 5| i");
        System.out.println(" 6| l");System.out.println(" 7| a");System.out.println(" 8| s");System.out.println(" 9| '");System.out.println("10| '");
        System.out.println(" ... ");System.out.println("|m|");
        System.out.println("");

        System.out.println("Listo, ya podemos comenzar a Jugar!!!");
        System.out.println("");

        int altura;
        System.out.print("Ingrese el Alto de la sopa de palabras:");
        altura = entrada.nextInt();
        while(altura < 15 ){
            System.out.println("Valor incorrecto, el Alto no puede ser menor que 15 ");
            System.out.println("Ingrese el Alto de la sopa de palabras nuevamente:");
            altura = entrada.nextInt();
        }

        while(altura > 80 ){
            System.out.println("Valor incorrecto, el Alto no puede ser mayor que 80 ");
            System.out.println("Ingrese el Alto de la sopa de palabras nuevamente:");
            altura = entrada.nextInt();
        }

        int ancho;
        System.out.print("Ingrese el ancho de la sopa de palabras:");
        ancho = entrada.nextInt();
        while(ancho < 15 ){
            System.out.println("Valor incorrecto, el Ancho no puede ser menor que 15 ");
            System.out.println("Ingrese el Ancho de la sopa de palabras nuevamente:");
            ancho = entrada.nextInt();
        }

        while(ancho > 80 ){
            System.out.println("Valor incorrecto, el Ancho no puede ser mayor que 80 ");
            System.out.println("Ingrese el Ancho de la sopa de palabras nuevamente:");
            ancho = entrada.nextInt();
        }

        System.out.println("");
        System.out.println("Ahora se debe ingresar la Ubicación de las Palabras en la Sopa, para lo cual solo se debe especificar Si o No.");
        System.out.println("");

        List<String> ubicaciones = new ArrayList<>();
        String horizontalIzqDerecha;
        System.out.println("Desea que las palabras estén ubicadas Horizontalmente de Izquierda a Derecha? ");
        horizontalIzqDerecha = entrada.next();

        while(!horizontalIzqDerecha.equalsIgnoreCase("Si") && !horizontalIzqDerecha.equalsIgnoreCase("No")){
            System.out.println("Respuesta incorrecta");
            System.out.println("Para seleccionar la Ubicación debe especificar Si o No ");
            horizontalIzqDerecha = entrada.next();
        }
        ubicaciones.add(horizontalIzqDerecha);

        String horizontalDerechaIzq;
        System.out.println("Desea que las palabras estén ubicadas Horizontal de Derecha a Izquierda? ");
        horizontalDerechaIzq = entrada.next();

        while(!horizontalDerechaIzq.equalsIgnoreCase("Si") && !horizontalDerechaIzq.equalsIgnoreCase("No")){
            System.out.println("Respuesta incorrecta");
            System.out.println("Para seleccionar la Ubicación debe especificar Si o No ");
            horizontalDerechaIzq = entrada.next();
        }
        ubicaciones.add(horizontalDerechaIzq);

        String verticalArribaAbajo;
        System.out.println("Desea que las palabras estén ubicadas Vertical de Arriba hacia Abajo? ");
        verticalArribaAbajo = entrada.next();

        while(!verticalArribaAbajo.equalsIgnoreCase("Si") && !verticalArribaAbajo.equalsIgnoreCase("No")){
            System.out.println("Respuesta incorrecta");
            System.out.println("Para seleccionar la Ubicación debe especificar Si o No ");
            verticalArribaAbajo = entrada.next();
        }
        ubicaciones.add(verticalArribaAbajo);

        String verticalAbajoArriba;
        System.out.println("Desea que las palabras estén ubicadas Vertical de Abajo hacia Arriba? ");
        verticalAbajoArriba = entrada.next();

        while(!verticalAbajoArriba.equalsIgnoreCase("Si") && !verticalAbajoArriba.equalsIgnoreCase("No")){
            System.out.println("Respuesta incorrecta");
            System.out.println("Para seleccionar la Ubicación debe especificar Si o No ");
            verticalAbajoArriba = entrada.next();
        }
        ubicaciones.add(verticalAbajoArriba);

        String diagonalIzqDerecha;
        System.out.println("Desea que las palabras estén ubicadas Diagonal de Izquierda a Derecha de Arriba hacia Abajo? ");
        diagonalIzqDerecha = entrada.next();

        while(!diagonalIzqDerecha.equalsIgnoreCase("Si") && !diagonalIzqDerecha.equalsIgnoreCase("No")){
            System.out.println("Respuesta incorrecta");
            System.out.println("Para seleccionar la Ubicación debe especificar Si o No ");
            diagonalIzqDerecha = entrada.next();
        }
        ubicaciones.add(diagonalIzqDerecha);

        String diagonalDerechaIzq;
        System.out.println("Desea que las palabras estén ubicadas Diagonal de Derecha a Izquierda de Abajo hacia Arriba? ");
        diagonalDerechaIzq = entrada.next();

        while(!diagonalDerechaIzq.equalsIgnoreCase("Si") && !diagonalDerechaIzq.equalsIgnoreCase("No")){
            System.out.println("Respuesta incorrecta");
            System.out.println("Para seleccionar la Ubicación debe especificar Si o No ");
            diagonalDerechaIzq = entrada.next();
        }
        ubicaciones.add(diagonalDerechaIzq);

        String diagonalIzqDerechaAbajoArriba;
        System.out.println("Desea que las palabras estén ubicadas Diagonal de Izquierda a Derecha de Abajo hacia Arriba? ");
        diagonalIzqDerechaAbajoArriba = entrada.next();

        while(!diagonalIzqDerechaAbajoArriba.equalsIgnoreCase("Si") && !diagonalIzqDerechaAbajoArriba.equalsIgnoreCase("No")){
            System.out.println("Respuesta incorrecta");
            System.out.println("Para seleccionar la Ubicación debe especificar Si o No ");
            diagonalIzqDerechaAbajoArriba = entrada.next();
        }
        ubicaciones.add(diagonalIzqDerechaAbajoArriba);

        String diagonalDerechaIzqArribaAbajo;
        System.out.println("Desea que las palabras estén ubicadas Diagonal de Derecha a Izquierda de Arriba hacia Abajo? ");
        diagonalDerechaIzqArribaAbajo = entrada.next();

        while(!diagonalDerechaIzqArribaAbajo.equalsIgnoreCase("Si") && !diagonalDerechaIzqArribaAbajo.equalsIgnoreCase("No")){
            System.out.println("Respuesta incorrecta");
            System.out.println("Para seleccionar la Ubicación debe especificar Si o No ");
            diagonalDerechaIzqArribaAbajo = entrada.next();
        }
        ubicaciones.add(diagonalDerechaIzqArribaAbajo);
        System.out.println("");

        System.out.println("Por último se debe ingresar la Categoria de las Palabras con las que desea jugar en la Sopa, " +
                           "para lo cual solo debe especificar el Número de la Categoría seleccionada.");
        System.out.println("");
        System.out.println("1  - Todas las palabras");
        System.out.println("2  - Animales");
        System.out.println("3  - Naturaleza");
        System.out.println("4  - Figuras");
        System.out.println("5  - Hogar");
        System.out.println("6  - Familia");
        System.out.println("7  - Paises");
        System.out.println("8  - Cuidades");
        System.out.println("9  - Deporte");
        System.out.println("10 - Profesiones");
        System.out.println("11 - Colores");

        System.out.println("");
        int categoria;
        System.out.print("Ingrese el número de la Categoria seleccionada:");
        categoria = entrada.nextInt();

        while(categoria < 1 || categoria > 11){
            System.out.println("");
            System.out.println("El número ingresado no corresponde a una Categoría");
            System.out.println("Para seleccionar una Categoría debe especificar un número entre 1 y 11, como se especificó anteriormente.");
            System.out.print("Ingrese el número de la Categoria seleccionada:");
            categoria = entrada.nextInt();
        }

        SopaDePalabras sp = new SopaDePalabras();
        sp.generarSopaDepalabras(altura, ancho, ubicaciones, categoria);

        System.out.println("");
        System.out.println("Cuando encuentre alguna palabra determine el valor de su Fila Inicial, el valor de su Columna Inicial, el valor de su Fila Final y el valor de su Columna Final");
        System.out.println("y vaya insertandolo según se le indica a continuación:");
        System.out.println("");

        int coordenadasDePalabras = sp.getCoordenasDePalabras().size();
       while(coordenadasDePalabras > 0) {
           if(coordenadasDePalabras != sp.getCoordenasDePalabras().size()){
               System.out.println("");
               System.out.println("Si encuentra alguna otra palabra continue escribiendo sus coordenadas como hizo anteriormente:");

           }
           System.out.println("Escriba el valor de la Fila Inicial");
           parAlturaInicial = entrada.nextInt();

           while(parAlturaInicial > sp.getSopaPalabras().length){
               System.out.println("El valor ingresado para la Fila Inicial es incorrecto, pues excede el Alto de la Sopa de Palabras ");
               System.out.println("Ingrese el valor de la Fila Inicial nuevamente:");
               parAlturaInicial = entrada.nextInt();
           }

           System.out.println("Escriba el valor de la Columna Inicial");
           parAnchoInicial = entrada.nextInt();

           while(parAnchoInicial > sp.getSopaPalabras()[0].length){
               System.out.println("El valor ingresado para la Columna Inicial es incorrecto, pues excede el Ancho de la Sopa de Palabras ");
               System.out.println("Ingrese el valor de la Columna Inicial nuevamente:");
               parAnchoInicial = entrada.nextInt();
           }

           System.out.println("Escriba el valor de la Fila Final");
           parAlturaFinal = entrada.nextInt();

           while(parAlturaFinal > sp.getSopaPalabras().length){
               System.out.println("El valor ingresado para la la Fila Final es incorrecto, pues excede el Alto de la Sopa de Palabras ");
               System.out.println("Ingrese el valor de la Fila Final nuevamente:");
               parAlturaFinal = entrada.nextInt();
           }

           System.out.println("Escriba el valor de la Columna Final");
           parAnchoFinal = entrada.nextInt();

           while(parAnchoFinal > sp.getSopaPalabras()[0].length){
               System.out.println("El valor ingresado para la Columna Final es incorrecto, pues excede el Ancho de la Sopa de Palabras ");
               System.out.println("Ingrese el valor de la Columna Final nuevamente:");
               parAnchoFinal = entrada.nextInt();
           }


           boolean coordenadasValidas =  sp.encontrarPalabraEnSopa(parAlturaInicial-1, parAnchoInicial-1, parAlturaFinal-1, parAnchoFinal-1);
           if(coordenadasValidas) {
               coordenadasDePalabras--;
           }
           if(coordenadasDePalabras == 0){

               System.out.println("");
               System.out.println("                         !!!FELICIDADES!!!!                          ");
               System.out.println("----Ha ganado el Juego, ya no quedan palabras por descubrir----");
           }
       }

    }

}
