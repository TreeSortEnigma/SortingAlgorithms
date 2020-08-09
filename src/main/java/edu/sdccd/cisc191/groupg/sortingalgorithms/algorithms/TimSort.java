// File:         TimSort.java
// Created:      07/16/2020
// Last Changed: 08/08/2020
// Author:     Indigo Columna

//Description:    This file contains the necessary code to complete a TimSort Algorithm.
package edu.sdccd.cisc191.groupg.sortingalgorithms.algorithms;

import edu.sdccd.cisc191.groupg.sortingalgorithms.SortManager;

public class TimSort extends Sortable {
    int delay;
    SortManager sortManager;

    public TimSort(int delay) { // set delay time in between steps
        this.delay = delay;
    }

    public void insertionSort(int[] array, int beginIndex, int endIndex) {
        int i, j, temp;
        for (i = beginIndex + 1; i <= endIndex; ++i) {
            j = i;
            sortManager.highlightedElements()[i] = "green"; // make the pivot green
            while (j > beginIndex && array[j] < array[j - 1]) {
                swap(j, j-1, array);
                --j;
            }
        }
    }

    private void pause() {
        try {
            Thread.sleep(sortManager.getDelay()); // pause the thread
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    private void swap(int indexA, int indexB, int [] array) {
        sortManager.swapIndices( indexA, indexB, array, sortManager );
        pause();
        sortManager.highlightedElements()[indexA] = ""; //remove the blue highlights.
        sortManager.highlightedElements()[indexB] = ""; //remove the blue highlights.
    }

    public void merge(int[] array, int a, int b, int c){
        int mergedSize = c - a + 1;
        int mergedArray[] = new int[mergedSize];
        int mergePos, leftPos, rightPos;

        mergePos = 0;
        leftPos = a;
        rightPos = b +1;

        while (leftPos <= b && rightPos <= c){
            if (array[leftPos] < array[rightPos]){
                mergedArray[mergePos] = array[leftPos];
                ++leftPos;
            } else {
                mergedArray[mergePos] = array[rightPos];
                ++rightPos;
            }
            ++mergePos;
        }

        while (leftPos <= b){
            mergedArray[mergePos] = array[leftPos];
            ++leftPos;
            ++mergePos;
        }

        while (rightPos <= c){
            mergedArray[mergePos] = array[rightPos];
            ++rightPos;
            ++mergePos;
        }

        for(mergePos = 0; mergePos < mergedSize; ++mergePos){
            array[a + mergePos] = mergedArray[mergePos];
            sortManager.setBarAndRePaint(a+mergePos, array[a+mergePos], sortManager);
            sortManager.highlightedElements()[a+mergePos] = "blue";
            pause();
            sortManager.highlightedElements()[a+mergePos] = "";
        }
    }

    public void timSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i += n/2) {
            insertionSort(arr, i, Math.min((i + (n/2)-1), (n-1)));
        }
        for (int size = n/2; size < n; size = 2 * size){
            for (int left = 0; left <n; left += 2 * size){
                int mid = left + size -1;
                int right = Math.min((left + 2 * size - 1), (n -1));
                merge(arr, left, mid, right);
            }
        }
    }

    @Override
    public void beginSort(int[] array, SortManager sortManager) {
        this.sortManager = sortManager;
        timSort(array);
    }
}