/*
Author: Andrew Leu 
FileName: ShellSort
Description of File: The shell sorting algorithm with gui implementation.  
 */
package edu.sdccd.cisc191.groupg.sortingalgorithms.algorithms;

import edu.sdccd.cisc191.groupg.sortingalgorithms.SortManager;

public class ShellSort extends Sortable {
    long delay;

    public ShellSort(int delay) { // set delay time in between steps
        this.delay = delay;
    }

    //print array
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    void sort(int arr[], SortManager sortManager){
        int gap = arr.length / 2;
        while(gap > 0){
            // Do a gapped insertion sort for this gap size.
            // The first gap elements a[0..gap-1] are already
            // in gapped order keep adding one more element
            // until the entire array is gap sorted
            for(int i = gap; i < arr.length; i+= 1) {
                // add a[i] to the elements that have been gap
                // sorted save a[i] in temp and make a hole at
                // position i
                int holder = arr[i];
                // shift earlier gap-sorted elements up until
                // the correct location for a[i] is found
                int j = 0;
                for (j = i; j >= gap && arr[j - gap] > holder; j -= gap) {
                    arr[j] = arr[j - gap];
                    sortManager.highlightedElements()[j] = "red";// set pivot to be green.
                    sortManager.stepCounter();
                    try {
                        Thread.sleep(sortManager.getDelay());
                    } catch (InterruptedException e) {
                        System.out.println(e);
                    }
                    sortManager.swapIndices( j, j - gap, arr, sortManager );
                    sortManager.stepCounter();
                    try {
                        Thread.sleep(sortManager.getDelay());
                    } catch (InterruptedException e) {
                        System.out.println(e);
                    }

                    sortManager.highlightedElements()[j] = ""; //remove the blue highlights.

                }

                // put temp (the original a[i]) in its correct
                // location
                arr[j] = holder;
                sortManager.highlightedElements()[j] ="";
            }
            gap = gap/2;

        }
    }

    public void beginSort(int[] array, SortManager sortManager){
        sort(array, sortManager);
    }
}
