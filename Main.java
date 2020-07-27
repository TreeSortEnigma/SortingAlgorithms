package com.company;
import javax.swing.*;
import java.util.Random;


public class Main {

    public static void main(String[] args) {

        //int[] array = {65, 68, 82, 42, 10, 75, 25, 47, 32, 72};

        int[] array = ArrayGenerator.generateArray(14);

        System.out.println("random unsorted array: ");

        for( int i : array ) {
            System.out.print(i + " ");
        }
        System.out.println(" ");

        System.out.println("sorted: ");
        TreeSort example = new TreeSort(array);
        example.sort();

        //To do:
        //UIWindow window = new UIWindow();
    }
}

class UIWindow {//Handles all User Interface things

    JFrame frame = new JFrame("Sorting Algorithm Visualizer");

    public UIWindow() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);

        //add additional UI elements here to take user input
    }


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

interface Sortable { //every algorithm will implement their own version of this method and return a sorted array.
    int[] sort();
}

class SortManager { //will handle all sorting tasks and return outputs back to the UI window.


}

class TreeSort implements Sortable {

    private BinaryTree tree;
    private int numElements;

    public TreeSort(int[] array) {

        numElements = array.length;
        tree = new BinaryTree( array );
    }

    public int[] sort() {

        tree.beginTraversal(); // sort the tree
        return tree.getArray(); // get sorted elements
    }
}

class Node { //node in a Binary Tree
    int value;
    Node left;
    Node right;

    Node ( int value ) {
        this.value = value;
        right = null;
        left = null;
    }
}

//values must be: left child < parent < rightChild in increasing order
class BinaryTree {

    Node root;
    int[] outputArray;// will hold the fully sorted array
    int[] inputArray;
    int index;// used to fill the output array.

    public BinaryTree( int[] inputArray ) {

        this.inputArray = inputArray;
        outputArray = new  int[inputArray.length];
        index = 0;

        for( int i : inputArray ){
            add(i);
        }
    }

    private Node addNode ( Node currentNode, int value) { //recursively loop through values

        if ( currentNode == null ) {
            return new Node ( value ); //Empty node, so add it. The first time we use addRoot, this returns a new node.
        }

        if ( value < currentNode.value ) { //a left child is added, being smaller than the root.
            currentNode.left = addNode( currentNode.left, value );
        } else if ( value > currentNode.value ) {//if it is greater, a right child.
            currentNode.right = addNode(currentNode.right, value);
        }
        return currentNode; //node already exists.
    }

    public void add ( int value ) {//starts addition from the root
        root = addNode( root, value );
    }

    //in-order: left -> root -> right
    public void inOrderTraversal(Node node) {//Do an inorder traversal while looping through the array and adding values. to start, use beginTraversal()

        if( node != null ) {
            inOrderTraversal( node.left );//check if left child exists. If it doesn't,
            //nothing will happen. if it does, it will be printed.
            System.out.print(" " + node.value);//print root node value
            outputArray[index] = node.value;//add value to the array
            index++;//increment index
            inOrderTraversal( node.right );//check if right child exists
        }
    }

    public void beginTraversal() //This kickstarts the traversal, which is needed because of the recursion.
    {
        inOrderTraversal(root);
    }

    public int[] getArray(){ //return the sorted array
        index = 0;
        return outputArray;
    }

}





