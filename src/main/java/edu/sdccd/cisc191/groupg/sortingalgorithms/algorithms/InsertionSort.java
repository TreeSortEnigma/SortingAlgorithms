package edu.sdccd.cisc191.groupg.sortingalgorithms.algorithms;

import edu.sdccd.cisc191.groupg.sortingalgorithms.SortManager;

public class InsertionSort extends Sortable {
    int delay;
    public InsertionSort(int delay) { // set delay time in between steps
        this.delay = delay;
    }

    @Override
    public void beginSort(int[] array, SortManager sortManager) {
        sort(array,sortManager);
    }

    public static void sort(int[] array,SortManager sortManager ) {
        int i, j, temp;
        for (i = 1; i < array.length; ++i) {
            j = i;
            while (j > 0 && array[j] < array[j - 1]) {
                sortManager.swapIndices( j, j-1, array, sortManager );
                try {
                    Thread.sleep(sortManager.getDelay()); // pause the thread
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
                sortManager.highlightedElements()[i] = "green";
                sortManager.highlightedElements()[j] = ""; //remove the blue highlights.
                sortManager.highlightedElements()[j-1] = ""; //remove the blue highlights.
                --j;
            }
        }
    }
}