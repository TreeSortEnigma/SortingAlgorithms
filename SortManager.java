package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SortManager extends SwingWorker {


    int xOffset;
    private int timesInitialized = 0;//this stops an exception from being thrown when the gui tries to draw an array before it's been created.
    private String[] highlightedElements;//this determines what color each index will be colored.
    private UIPanel uiPanel; // This is where all the UI elements will be. Also draws the sorting bars.
    Sortable algorithm; // current algorithm
    private Rectangle[] bars; // holds the rectangular bars representing array elements.
    private int[] array; // holds all values of the array.
    private int delay = 100; // delay time in between each sorting step.

    public SortManager( int algType ) {

        uiPanel = new UIPanel(this);

        switch ( algType ) {
            case 0 : algorithm = new QuickSort(delay);
                System.out.println("quicksort selected");
                break;
            case 1 : algorithm = new SelectionSort(delay);
                System.out.println("selection sort selected");
                break;
            case 2 : algorithm = new BubbleSort(delay);
                System.out.println("bubble sort selected");
                break;
            case 3 : algorithm = new ShellSort(delay);
                System.out.println("shell sort selected");
                break;
        }
    }

    //call this method any time in your sort you want to swap
    public void swapIndices(int i, int j, int[] arr, SortManager sortManager ) {

        //both elements will be highlighted at once. remember to
        //reset these bars to "" which will turn them black, after the sleeping the thread.
        sortManager.highlightedElements[i] = "blue";
        sortManager.highlightedElements[j] = "blue";

        sortManager.getUIPanel().repaint();//redraw

        //simultaneously swap the array values and their respective rectangles
        int temp = arr[i];
        sortManager.setBar(j, new Rectangle(j * 20 + xOffset, 100, 5, arr[i]));
        arr[i] = arr[j];
        sortManager.setBar(i, new Rectangle(i * 20 + xOffset, 100, 5, arr[j]));
        arr[j] = temp;
        System.out.println("indices " + i + " and " + j + " swapped.");

    }

    public void drawBars(){// this takes an array and draws all the corresponding bars onto the UI.

        highlightedElements = new String[array.length];
        xOffset = 100;

        bars = new Rectangle[ array.length ];
        for ( int x = 0; x < array.length; x++) {

            bars[x] = new Rectangle(x * 20 + xOffset ,100,5, array[x]);
            highlightedElements[x] = "";

            System.out.println("added bar to array at index "  + x);
        }
        uiPanel.repaint();
        timesInitialized++;
    }

    @Override
    protected Object doInBackground() { //kicks off a worker thread to begin the sorting.

            algorithm.beginSort(array, this);

        return null;
    }

    //various accessor/mutators
    public void setBar(int i, Rectangle rect){
        bars[i] = rect;
    }
    public Rectangle getBar(int index){
        return bars[index];
    }
    public Rectangle[] getBars(){
        return bars;
    }
    public void setDelay(int delay) {
        this.delay = delay;
    }
    public int getDelay(){
        return delay;
    }
    public int[] getArray() {
        return array;
    }
    public void setArray(int[] array){
        this.array = array;
    }
    public UIPanel getUIPanel(){
        return uiPanel;
    }
    public int getTimesInitialized(){
        return timesInitialized;
    }
    public void addTimesInitialized(){
        timesInitialized ++;
    }

    public String[] highlightedElements(){ // stores highlight status of every box in the bar.
        return highlightedElements;
    }

}
