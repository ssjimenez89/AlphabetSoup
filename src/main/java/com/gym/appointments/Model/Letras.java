package com.gym.appointments.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Letras {

  List<Character> letras = new ArrayList<>(Arrays.asList('a','b','c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q', 'r', 's', 't', 'u','v','w','x','y','z' ));


    public Character letrasRandom(){
        Character ch = letras.get((int) (Math.random()* 27));
        return ch;
    }
}
