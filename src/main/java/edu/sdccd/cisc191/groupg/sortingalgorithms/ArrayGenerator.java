package edu.sdccd.cisc191.groupg.sortingalgorithms;

import java.util.Random;

class ArrayGenerator {
    static int[] generateArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for( int i = 0; i < size; i++ ) {
            array[i] = random.nextInt(100);
        }
        return array;
    }
}
