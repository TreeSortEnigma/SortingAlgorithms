package com.cisc191;

// Referenced:
// https://www.javatpoint.com/insertion-sort-in-java
// Zybooks 17.7 Insertion Sort
public class InsertionSort {
    public static int[] sort(int [] array){
        int i, j, temp;
        for (i = 1; i < array.length; ++i){
            j = i;
            while (j > 0 && array [j] < array[j - 1]){
                temp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = temp;
                --j;
            }
        }

        return array;
    }
}
