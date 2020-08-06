package com.company;

// here we have quicksort being used as an example. every time the the left to right marker is
// incremented, a pause occurs. any time values are swapped, an second pause also occurs.
class QuickSort extends Sortable {

    long delay;

    public QuickSort(int delay) { // set delay time in between steps
        this.delay = delay;
    }

    //recursive partition. this is the meat and potatoes of the sort.
    int partition(int array[], int lowIndex, int highIndex, SortManager sortManager) throws InterruptedException{
        //in the first round, pivot is last index.

        int pivot = array[highIndex];
        sortManager.highlightedElements()[highIndex] = "green";// set pivot to be green.

        System.out.println("pivot: " + pivot);
        int i = (lowIndex - 1); // left pointer index set to low input.

        for (int j = lowIndex; j < highIndex; j++) //loop from left to right.
        {
            System.out.println("value of j before increment: " + j);

            sortManager.highlightedElements()[j] = "red";//highlight this first step

            sortManager.getUIPanel().repaint();//redraw

            Thread.sleep(sortManager.getDelay()); // pause the thread

            // If we encounter a smaller value than the pivot,
            if (array[j] <= pivot) {

                i++; //move left pointer right 1. also this way it can never return -1.

                //sortManager.highlightedElements()[j] = "";//this thing will turn blue, so remove the old highlight.

                sortManager.swapIndices( i, j, array, sortManager );// swap arr[i] and arr[j] and turn the bars blue.

                // this will update the rectangles drawn so they show up in the right place.
                // repaint will always come before sleeping, so the user can see the change in color for a moment.

                //System.out.println("value of i after increment: " + i);

                Thread.sleep(sortManager.getDelay());//pause since a swap occured.

                sortManager.highlightedElements()[i] = ""; //remove the blue highlights.
                //sortManager.highlightedElements()[j] = "";

            }
            sortManager.highlightedElements()[j] = ""; // if we didn't encounter a smaller value than the pivot, return the red highlight to black.

            sortManager.getUIPanel().repaint();//redraw

            printArray(array);
        }
        sortManager.swapIndices( (i+1), highIndex, array, sortManager );// swap arr[i+1] and arr[high], the latter of which which may also be the pivot. swap their respective bars.

        Thread.sleep(sortManager.getDelay());//pause since a swap occurred

        sortManager.highlightedElements()[(i+1)] = ""; //remove the blue highlights.
        sortManager.highlightedElements()[(highIndex)] = "";

        System.out.println("indices " + (i + 1) + " and " + highIndex + " swapped. result: ");
        printArray(array);
        return i + 1; //returns 0 if all elements to the right are larger than the left pointer
    }

    //recursive sort. this is kind of like a gateway.
    void sort(int arr[], int low, int high, SortManager sortManager ) {

        if (low < high) {
			/* pi is partitioning index, arr[pi] is
			now at right place */
            try {
                int pi = partition(arr, low, high, sortManager);
                System.out.println("after partition: ");
                printArray(arr);

                // Recursively sort elements before partition
                sort(arr, low, pi - 1, sortManager);
                // and after partition
                sort(arr, pi + 1, high, sortManager);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    /* A utility function */
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    @Override //this is the entry point. SortManager is passed in to allow access to the bars being redrawn.
    public void beginSort(int[] array, SortManager sortManager) {
        sort(array, 0, array.length-1, sortManager);
    }
}
