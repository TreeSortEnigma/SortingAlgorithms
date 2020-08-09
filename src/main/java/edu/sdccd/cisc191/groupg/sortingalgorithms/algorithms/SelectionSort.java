package edu.sdccd.cisc191.groupg.sortingalgorithms.algorithms;

import edu.sdccd.cisc191.groupg.sortingalgorithms.SortManager;

public class SelectionSort extends Sortable{
    int delay;

    public SelectionSort(int delay) { // set delay time in between steps
        this.delay = delay;
    }

    @Override
    public void beginSort(int[] array, SortManager sortManager) {
        sort(array, sortManager);
    }

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
            sortManager.highlightedElements()[i] = ""; //remove the blue highlights.
            sortManager.highlightedElements()[smallestNumber] = ""; //remove the blue highlights.
        }
    }
}
