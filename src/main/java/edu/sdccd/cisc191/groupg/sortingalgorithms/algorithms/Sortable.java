package edu.sdccd.cisc191.groupg.sortingalgorithms.algorithms;

import edu.sdccd.cisc191.groupg.sortingalgorithms.SortManager;

public abstract class Sortable { //every algorithm will implement this method.

    //this method is called beginSort() rather than sort() to avoid interfering with recursive sorts.
    //call sort() inside this method to kick off a recursive sort.
    public abstract void beginSort( int[] array, SortManager sortManager);
}