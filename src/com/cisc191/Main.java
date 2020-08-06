package com.cisc191;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	    // write your code here
        int[] sampleArray = new int[]{4,16,64,8,5,9,7};
        int[] sortedArray = SelectionSort.sort(sampleArray.clone());
        int[] sortedArrayTwo = InsertionSort.sort(sampleArray.clone());
        int[] sortedArrayThree = TimSort.sort(sampleArray.clone());
        System.out.println(Arrays.toString(sampleArray));
        System.out.println(Arrays.toString(sortedArray));
        System.out.println(Arrays.toString(sortedArrayTwo));
        System.out.println(Arrays.toString(sortedArrayThree));
    }
}
