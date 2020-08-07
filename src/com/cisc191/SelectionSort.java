package com.cisc191;

import java.util.Arrays;

public class SelectionSort extends Sortable{
    int delay;

    public SelectionSort(int delay) { // set delay time in between steps
        this.delay = delay;
    }

    @Override
    public void beginSort(int[] array, SortManager sortManager) {
        sort(array, sortManager);
    }

    //recursive sort. this is kind of like a gateway.
    void sort(int[] array, SortManager sortManager ) {
        int i, j, smallestNumber;
        for (i = 0; i < array.length -1; i++) {
            smallestNumber = i;
            for (j = i + 1; j < array.length; j++) {
                if (array[j] < array[smallestNumber]) {
                    smallestNumber = j;
                }
            }

            sortManager.swapIndices( i, smallestNumber, array, sortManager );

            try {
                Thread.sleep(sortManager.getDelay()); // pause the thread
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            Arrays.fill(sortManager.highlightedElements(), "");
        }
    }
}