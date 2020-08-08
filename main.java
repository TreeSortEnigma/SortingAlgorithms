import java.util.Arrays;

public class main {
  public static void main(String[] args) {
   int[] inputArr = new int[]{3, 4, 2, 7, 1, 5, 8, 6};
   int[] expectedArr = new int[] {1, 2, 3, 4, 5, 6, 7, 8};

   System.out.println("Original Array was " + Arrays.toString(inputArr));
   System.out.println("Expected Array was " + Arrays.toString(expectedArr));
   System.out.println("Actual Array was " + Arrays.toString(bubbleSort.bubbleSort(inputArr)));

  }
}
