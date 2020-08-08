package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;


public class Main  {

    public static void main(String[] args) throws InterruptedException {

        //using an arraylist here allows for quick adding and deleting of sorting threads since
        //execute can only be used once per SortManager.
        ArrayList<SortManager> managers = new ArrayList<SortManager>();

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
        JTextField arraySizeField = new JTextField("",1);
        arraySizeField.setText("");
        JTextField delayField = new JTextField(1);
        delayField.setText("");
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(null);
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JPanel algPanel = new JPanel(new BorderLayout());

        //code for the drop down menu. right now this doesn't do anything.
        //additional algorithms can be added to the string array.
        String[] algMenuOptions = {"QuickSort", "SelectionSort", "BubbleSort", "ShellSort"};
        JComboBox algMenu = new JComboBox(algMenuOptions);
        algMenu.setSelectedIndex(0);
        algMenu.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("sort index: " + algMenu.getSelectedIndex());
                //algMenu.setSelectedIndex(e.);
            }
        });

        //the generate button prepares all the essential elements.
        JButton generateButton = new JButton( new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                for ( SortManager manager : managers) { // stop current sorting

                    manager.cancel(true);
                }

                managers.clear();// delete the manager/sorting thread
                SortManager sortManager = new SortManager(algMenu.getSelectedIndex()); //replace it with a new one
                managers.add(sortManager);

                int delay = 50; //default values if the user enters nothing
                int size = 30;

                if ( !arraySizeField.getText().trim().equals("") ) {  //filter out integer inputs for delay/# of elements.
                    size = Integer.parseInt(arraySizeField.getText());
                }
                if ( !delayField.getText().trim().equals("") ) {
                    delay = Integer.parseInt(delayField.getText());
                }

                sortManager.setArray(ArrayGenerator.generateArray(size)); // initialize everything
                sortManager.setDelay(delay);
                sortManager.drawBars();
                sortManager.getUIPanel().setPreferredSize(new Dimension(800, 400));
                frame.add(sortManager.getUIPanel(),BorderLayout.SOUTH);
                frame.setVisible(true);

            }
        });
        generateButton.setText("Generate!");

        //button to begin the sort
        JButton sortButton = new JButton( new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for ( SortManager manager : managers)
                    manager.execute();
            }
        });
        sortButton.setText("Sort!");

        //here we add the gui elements onto the frmae.
        //set up the subpanels
        overPanel.setPreferredSize(new Dimension(800,200));
        //input field
        inputPanel.setPreferredSize(new Dimension(800,30));
        arraySizeLabel.setBounds(200,10,70,20);
        inputPanel.add(arraySizeLabel);
        arraySizeField.setBounds(280,10,50,20);;
        inputPanel.add(arraySizeField);
        //delay field
        inputPanel.add(delayLabel);
        delayLabel.setBounds(400,10,70,20);
        inputPanel.add(delayField);
        delayField.setBounds(480,10,50,20);;
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


