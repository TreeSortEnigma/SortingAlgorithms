package com.cisc191;

public class SelectionSort {
    // Referenced:
    // https://www.geeksforgeeks.org/selection-sort/
    // Zybook 17.6 Selection Sort
    public static int[] sort(int[] arrayList) {
        int i, j, smallestNumber;
        for (i = 0; i < arrayList.length -1; i++) {
            smallestNumber = i;
            for (j = i + 1; j < arrayList.length; j++) {
                if (arrayList[j] < arrayList[smallestNumber]) {
                    smallestNumber = j;
                }
            }
            int temp = arrayList[i];
            arrayList[i] = arrayList[smallestNumber];
            arrayList[smallestNumber] = temp;
        }

        return arrayList;
    }
}
