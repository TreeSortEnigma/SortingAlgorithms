// File:         Sortable.java
// Created:      07/16/2020
// Last Changed: 08/08/2020
// Author:       
// 
//Description:    This file contains the necessary code to complete a Sortable Algorithm.

package edu.sdccd.cisc191.groupg.sortingalgorithms.algorithms;

import edu.sdccd.cisc191.groupg.sortingalgorithms.SortManager;

public abstract class Sortable { //every algorithm will implement this method.

    //this method is called beginSort() rather than sort() to avoid interfering with recursive sorts.
    //call sort() inside this method to kick off a recursive sort.
    public abstract void beginSort( int[] array, SortManager sortManager);
}
