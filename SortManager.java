package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class SortManager extends SwingWorker {

    int xOffset;
    private boolean isReady = false;//this stops an exception from being thrown when the gui tries to draw an array before it's been created.
    private String[] highlightedElements;//this determines what color each index will be colored.
    private UIPanel uiPanel; // This is where all the UI elements will be. Also draws the sorting bars.
    ArrayList<Sortable> algorithms; // holds algorithms to use for sorting. may be used for concurrency.
    private Rectangle[] bars; // holds the rectangular bars representing array elements.
    private int[] array; // holds all values of the array.
    private int delay = 500; // delay time in between each sorting step.

    public SortManager( ) {

        uiPanel = new UIPanel(this);

        algorithms = new ArrayList<Sortable>();

        algorithms.add( new QuickSort(delay) );

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
        sortManager.setBar(j, new Rectangle(j * 20 + xOffset, uiPanel.getHeight()/2, 5, arr[i]));
        arr[i] = arr[j];
        sortManager.setBar(i, new Rectangle(i * 20 + xOffset, uiPanel.getHeight()/2, 5, arr[j]));
        arr[j] = temp;
        System.out.println("indices " + i + " and " + j + " swapped.");
    }

    public void drawBars(){// this takes an array and draws all the corresponding bars onto the UI.

        highlightedElements = new String[array.length];
        xOffset = uiPanel.getWidth()/2 - (array.length * 20)/2;

        bars = new Rectangle[ array.length ];
        for ( int x = 0; x < array.length; x++) {

            bars[x] = new Rectangle(x * 20 + xOffset ,uiPanel.getHeight()/2,5, array[x]);
            highlightedElements[x] = "";

            System.out.println("added bar to array at index "  + x);
        }
        isReady = true;
        uiPanel.repaint();
    }

    @Override
    protected Object doInBackground() { //kicks off a worker thread to begin the sorting.

        for (Sortable sortable : algorithms) {
            sortable.beginSort(array, this);
        }
        return null;
    }

    //various accessor/mutators
    public void setBar(int i, Rectangle rect){
        bars[i] = rect;
    }
    public Rectangle getBar(int index){
        return bars[index];
    }
    public void setBars( Rectangle[] bars ) {
        this.bars = bars;
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
    public void setIndex(int index, int value) {
        array[index] = value;
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
    public boolean isReady(){
        return isReady;
    }
    public String[] highlightedElements(){
        return highlightedElements;
    }

}
