// File:         MergeSort.java
// Created:      08/08/2020
// Last Changed: 08/08/2020
// Author:       Hedy Wang
//               hewang985@gmail.com
//Description:   This file contains the necessary code to complete a MergeSort Algorithm.
//Reference:     https://www.geeksforgeeks.org/merge-sort/
//
//package edu.sdccd.cisc191.groupg.sortingalgorithms.algorithms;
//
//import edu.sdccd.cisc191.groupg.sortingalgorithms.SortManager;
//
//    public class MergeSort extends Sortable {
//
//    long delay;
//
//    public MergeSort(int delay) { // set delay time in between steps
//
//        this.delay = delay;
//    }
//
//    // Merges two subarrays of arr[]
//    // First subarray is arr[l..m]
//    // Second subarray is arr[m+1..r]
//
//    void merge (int array[], int left, int middle, int right, SortManager sortManager) throws InterruptedException{
//
//    //find  sizes of two subarrays to be merged
//
//    //find sizes of two subarrays to be merged
//    int s1 = middle - left + 1;
//    int s2 = right - middle;
//
//
//    //create temp arrays
//    int L[] = new int[s1];
//    int R[] = new int[s2];
//
//    //copy data to temp arrays
//    for (int i = 0; i < s1; ++i)
//        L[i] = arr[left+i];
//    for (int j = 0; j<s2; ++j)
//        R[j] = arr[middle + 1 + j];
//
//    // highlight left subarray
//    sortManager.highlightedElements()[s1] = "green";
//
//    // highlight this first step
//    sortManager.highlightedElements()[s2] = "red";
//
//
//    // merge the temp arrays
//    // Initial index of merged subarry array
//    int k = left;
//    while (i < s1 && j < s2){
//        if (L[i] <= R[i]){
//            arr[k] = L[i];
//            i++;
//        }
//        else{
//            arr[k] = R[j];
//            j++;
//        }
//        k++;
//
//
//    }
//
//    // copy remaining elements of L[] if any
//    while (i < s1){
//        arr[k] = L[i];
//        i++;
//        k++;
//
//        // highlight left subarray
//        sortManager.highlightedElements()[i] = "green";
//
//        sortManager.getUIPanel().repaint();//redraw
//
//        sortManager.stepCounter();
//        Thread.sleep(sortManager.getDelay()); // pause the thread
//
//    }
//
//    // copy remaining elements of L[] if any
//    while (j < s2){
//        arr[k] = R[j];
//        j++;
//        k++;
//
//        // highlight right subarray
//        sortManager.highlightedElements()[j] = "red";
//
//        sortManager.getUIPanel().repaint();//redraw
//
//        sortManager.stepCounter();
//        Thread.sleep(sortManager.getDelay()); // pause the thread
//
//    }
//
//    // Main function that sorts arr[l..r] using merge()
//
//        void sort (int array[], int left, int right){
//           if (left < right){
//               // Find the middle point
//                int middle = (left + right) / 2;
//
//                //Sort first and second halves
//                sort(array, left, middle);
//                sort(array, middle + left, right);
//
//                //Merge the sorted halves
//                merge(array, left, middle, right);
//           }
//
//        catch (Exception e) {
//          System.out.println(e);
//            }
//        }
//
//        /* A utility function */
//        static void printArray(int arr[]) {
//            int n = arr.length;
//            for (int i = 0; i < n; ++i)
//                System.out.print(arr[i] + " ");
//            System.out.println();
//        }
//
//        @Override //this is the entry point. SortManager is passed in to allow access to the bars being redrawn.
//        public void beginSort(int[] array, SortManager sortManager) {
//            sort(array, 0, array.length-1, sortManager);
//        }
//        }
