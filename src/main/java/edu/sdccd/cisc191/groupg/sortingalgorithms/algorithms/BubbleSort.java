// File:         BubbleSort.java
// Created:      07/16/2020
// Last Changed: 08/08/2020
// Author:       Abigail Swinson
//                abigail.swinson@yahoo.com
//Description:    This file contains the necessary code to visualize the BubbleSort sorting algorithm and keeping track of the steps taken
//                during the sorting process.


package edu.sdccd.cisc191.groupg.sortingalgorithms.algorithms;
import edu.sdccd.cisc191.groupg.sortingalgorithms.SortManager;

public class BubbleSort extends Sortable {

  long delay;

  public BubbleSort(int delay) {
    this.delay = delay;
  }

  @Override //this is the entry point. SortManager is passed in to allow access to the bars being redrawn.
  public void beginSort(int[] array, SortManager sortManager) {
      sort(array, sortManager);
  }
  
  // this is the actual BubbleSort algorithm which takes in the int[] to be sorted
  public void sort(int[] inputArr, SortManager sortManager) {
    int i, j, plusOne, tempInt = 0;
    int length = inputArr.length;

    for( i = 0; i < length-1; i++) //loops over the indices of the array
    {
      for( j = 0; j < length-1-i; j++) //loops over the sub-indices
      {
        if(inputArr[j] > inputArr[j+1]) //checks to see if a swap is needed
        {

          sortManager.highlightedElements()[j]= "red";
//          sortManager.getUIPanel().repaint();
          plusOne = j+1;

          tempInt = inputArr[j+1];
          inputArr[j+1] = inputArr[j];
          inputArr[j] = tempInt;

          sortManager.swapIndices( (j+1), plusOne, inputArr, sortManager );
//          sortManager.getUIPanel().repaint();
          
          //adds one to the counter int and prints current step number
          sortManager.stepCounter();
          
          try {
            Thread.sleep(sortManager.getDelay());
          } catch (InterruptedException e) {
            System.out.println(e);
          }
        }

      sortManager.highlightedElements()[j] ="";
//      sortManager.getUIPanel().repaint();
      }

      sortManager.highlightedElements()[j]= "";
//      sortManager.getUIPanel().repaint();
    }
  }
}

