public class bubbleSort extends Sortable {

  long delay;

  public bubbleSort(int delay) {
    this.delay = delay;
  }

  @Override //this is the entry point. SortManager is passed in to allow access to the bars being redrawn.
  public void beginSort(int[] array, SortManager sortManager) {
      sort(array, sortManager);
  }

  void sort(int[] inputArr, SortManager sortManager) {
    int i, j, tempInt= 0;
    int length = inputArr.length;
    for( i = 0; i < length-1; i++) //loops over the indices of the array
    {
      for( j = 0; j < length-1-i; j++) //loops over the sub-indices
      {

        if(inputArr[j] > inputArr[j+1]) {

          sortManager.highlightedElements()[j]= "red";
          sortManager.getUIPanel().repaint();


          tempInt = inputArr[j+1];
          inputArr[j+1] = inputArr[j];
          inputArr[j] = tempInt;


          sortManager.swapIndices( j, j+1, inputArr, sortManager );

          try {
            Thread.sleep(sortManager.getDelay());
          } catch (InterruptedException e) {
            System.out.println(e);
          }

        }


      sortManager.highlightedElements()[j] ="";

      sortManager.getUIPanel().repaint();


      }
    }

  }


}
