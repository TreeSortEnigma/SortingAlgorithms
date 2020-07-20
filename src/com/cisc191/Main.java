package com.cisc191;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] sampleArray = new int[]{4,16,64,8,5,9,7};
        int[] sortedArray = SelectionSort.sort(sampleArray);
        System.out.println(Arrays.toString(sortedArray));
    }
}
