package com.cisc191;

import java.util.Random;

public class ArrayGenerator { //returns a randomly generated array of certain size

    static int[] generateArray( int size) {
        Random random = new Random();
        int[] array = new int[size];
        for( int i = 0; i < size; i++ ) {
            array[i] = random.nextInt(100);
        }
        return array;
    }
}