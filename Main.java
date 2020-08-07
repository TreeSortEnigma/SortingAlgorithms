package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;


public class Main  {

    public static void main(String[] args) throws InterruptedException {

        //the central hub. this will be given to the UIPanel.
        SortManager sortManager = new SortManager();

        //gui stuff
        JFrame frame = new JFrame("Sorting Algorithm Visualizer");
        JPanel overPanel = new JPanel();
        overPanel.setLayout(new BoxLayout(overPanel,BoxLayout.PAGE_AXIS ));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        JLabel arraySizeLabel = new JLabel("Array Size: ");
        JLabel algorithmLabel = new JLabel("Algorithm: ");
        JLabel delayLabel = new JLabel("Delay(ms): ");
        JLabel resultsLabel = new JLabel( " Results: ");
        JButton addAlgorithm = new JButton("+");
        JTextField arraySizeField = new JTextField("",1);
        JTextField delayField = new JTextField(1);
        JPanel inputPanel = new JPanel(new FlowLayout());
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JPanel algPanel = new JPanel(new BorderLayout());

        //code for the drop down menu. right now this doesn't do anything.
        //additional algorithms can be added to the string array.
        String[] algMenuOptions = {"Quicksort"};
        JComboBox algMenu = new JComboBox(algMenuOptions);
        algMenu.setSelectedIndex(0);
        algMenu.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        //the generate button prepares all the essential elements.
        JButton generateButton = new JButton( new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int delay, size;

                if (arraySizeField.getText().trim() == "") {
                    size = 30;
                } else {
                    size = Integer.parseInt(arraySizeField.getText());
                }

                if (delayField.getText().trim() == "") {
                    delay = 200;
                } else {
                    delay = Integer.parseInt(delayField.getText());
                }
                sortManager.setArray(ArrayGenerator.generateArray(size));
                sortManager.setDelay(delay);
                sortManager.drawBars();
            }
        });
        generateButton.setText("Generate!");

        //button to begin the sort
        JButton sortButton = new JButton( new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sortManager.execute();
            }
        });
        sortButton.setText("Sort!");

        //here we add the gui elements onto the frmae.
        //set up the subpanels
        sortManager.getUIPanel().setPreferredSize(new Dimension(800, 400));
        overPanel.setPreferredSize(new Dimension(800,200));
        frame.add(sortManager.getUIPanel(),BorderLayout.SOUTH);
        //input field
        inputPanel.setPreferredSize(new Dimension(800,30));
        inputPanel.add(arraySizeLabel);
        inputPanel.add(arraySizeField);
        //delay field
        inputPanel.add(delayLabel);
        inputPanel.add(delayField);
        overPanel.add(inputPanel,BorderLayout.NORTH);
        //buttons
        buttonPanel.setPreferredSize(new Dimension(800,30));
        buttonPanel.add(generateButton);
        buttonPanel.add(sortButton);
        overPanel.add(buttonPanel,FlowLayout.CENTER);
        //algorithm select
        algMenu.setPreferredSize(new Dimension(800,30));
        algPanel.add(algorithmLabel, BorderLayout.WEST);
        algPanel.add(algMenu);
        overPanel.add(algPanel);

        frame.add(overPanel,BorderLayout.NORTH);
        frame.setVisible(true);

    }

}

abstract class Sortable { //every algorithm will implement this method.

    //this method is called beginSort() rather than sort() to avoid interfering with recursive sorts.
    //call sort() inside this method to kick off a recursive sort.
    public abstract void beginSort( int[] array, SortManager sortManager);
}


class ArrayGenerator { //returns a randomly generated array of certain size

    static int[] generateArray( int size) {
        Random random = new Random();
        int[] array = new int[size];
        for( int i = 0; i < size; i++ ) {
            array[i] = random.nextInt(100);
        }
        return array;
    }
}


