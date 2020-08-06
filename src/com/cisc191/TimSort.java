package com.cisc191;
//Referenced:
//Zybooks 17.9 Merge Sort
//https://www.geeksforgeeks.org/timsort/
//https://en.wikipedia.org/wiki/Timsort
public class TimSort {
    public static void insertionSort(int [] array, int beginIndex, int endIndex){
        int i, j, temp;
        for (i = beginIndex + 1; i <= endIndex; ++i){
            j = i;
            while (j > beginIndex && array [j] < array[j - 1]){
                temp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = temp;
                --j;
            }
        }
    }

    public static void merge(int[] array, int a, int b, int c){
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
            }
            else {
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
        }
    }

    public static void mergeSort(int[]array, int a, int c){
        int b;

        if(a < c){
            b = (a + c) / 2;
            mergeSort(array, a, b);
            mergeSort(array, b+1, c);
            merge(array, a,b,c);
        }
    }

    private static final int MAX_INSERTION_SORT_ARRAY_LENGTH = 16;

    public static int[] sort(int[] array){
        int d = array.length;
        for(int i = 0; i< d; i += MAX_INSERTION_SORT_ARRAY_LENGTH) {
            insertionSort(array, i, Math.min((i + MAX_INSERTION_SORT_ARRAY_LENGTH-1), (d - 1)));
        }

        // start merging from size MAX_INSERTION_SORT_ARRAY_LENGTH (or 16). It will merge
        // to form size 64, then 128, 256 and so on ....
        for (int size = MAX_INSERTION_SORT_ARRAY_LENGTH; size < d; size = 2 * size)
        {

            // pick starting point of left sub array. We
            // are going to merge arr[left..left+size-1]
            // and arr[left+size, left+2*size-1]
            // After every merge, we increase left by 2*size
            for (int left = 0; left < d; left += 2 * size)
            {

                // find ending point of left sub array
                // mid+1 is starting point of right sub array
                int mid = left + size - 1;
                int right = Math.min((left + 2 * size - 1), (d - 1));

                // merge sub array arr[left.....mid] &
                // arr[mid+1....right]
                merge(array, left, mid, right);
            }
        }
        return array;
    }
}
