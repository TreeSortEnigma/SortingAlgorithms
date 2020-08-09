package edu.sdccd.cisc191.groupg.sortingalgorithms;

import javax.swing.*;
import java.awt.*;

class UIPanel extends JPanel {//This is basically just a Jpanel that draws all the boxes.

    SortManager sortManager;

    public UIPanel( SortManager sortManager ) {
        this.setBackground(Color.GRAY);
        this.sortManager = sortManager;

    }

    @Override
    public void paint( Graphics g ) {// automatically draws the bars in real time without needing to be called manually.
        super.paint(g);
        Graphics2D graphics = (Graphics2D) g;
        graphics.setColor(Color.black);

        if(sortManager.getTimesInitialized() > 0) {//make sure everything's initialized first.
            for (int x = 0; x < sortManager.getArray().length; x++) {

                if(sortManager.highlightedElements()[x] == "blue") {// if an element is getting swapped, the index in the array says "blue".
                    graphics.setColor(Color.blue);
                } else if (sortManager.highlightedElements()[x] == "red") {// if an element is being incremented over, it turns red.
                    graphics.setColor(Color.red);
                } else if (sortManager.highlightedElements()[x] == "green") {// this is for the pivot in quicksort, can be used for any tertiary role.
                    graphics.setColor(Color.green);
                } else {
                    graphics.setColor(Color.black);// if the index in the array is "", nothing is currently being done to this index.
                }
                graphics.draw(sortManager.getBars()[x]);//draw the bar at this index.
                graphics.fillRect((int)sortManager.getBar(x).getX() ,(int)sortManager.getBar(x).getY(),5, sortManager.getArray()[x]);//give it the appropriate color.

            }
        }
    }
}