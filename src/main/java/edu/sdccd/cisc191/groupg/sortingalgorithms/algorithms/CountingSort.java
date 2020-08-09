package edu.sdccd.cisc191.groupg.sortingalgorithms.algorithms;

class CountingSort {
  public static int[] countingSort(int[] inputArr) {
    int i, j, k, l, m, max = 0;
    int length = inputArr.length;
    int[] finalArr = new int[length];

    for (i=0; i<length-1; i++) {
      if (inputArr[i] > max) {
        max = inputArr[i];
      }
    }

    int[] counterArr = new int[max+1];

    for (j=0; j<length; j++) {
      for (k=0; k<=max+1; k++){
        if (inputArr[j] == k) {
          counterArr[k] = counterArr[k] + 1;
        }
      }
    }

    for (l=0; l<=max; l++) {
      if (l > 0) {
        counterArr[l] = counterArr[l]+ counterArr[l-1];
      }
    }

    for (m=0; m<length; m++) {
      int tempInt = inputArr[m];
      finalArr[counterArr[tempInt]-1] = tempInt;
      counterArr[tempInt] = counterArr[tempInt] -1;
    }

    return finalArr;
  }
}
