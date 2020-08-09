// File:         ArrayGenerator.java
// Created:      
// Last Changed: 08/08/2020
// Author:       Hailun Xu
// 
//Description:    This file contains the necessary code to generate a random Array when the user hits “generate".

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
