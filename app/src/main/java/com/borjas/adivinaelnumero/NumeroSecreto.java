package com.borjas.adivinaelnumero;

import java.util.Random;

public class NumeroSecreto {
    private int numRandom;
    private Random random = new Random();

    public NumeroSecreto() {
        this.numRandom = random.nextInt(10);
    }

    public int getNumRandom() {
        return numRandom;
    }

    public void setNumRandom(int numRandom) {
        this.numRandom = numRandom;
    }

    public void generarNumRand(){
       setNumRandom(random.nextInt(10));
    }

    public String numToString(){
        String num = String.valueOf(getNumRandom());
        return num;
    }
}
