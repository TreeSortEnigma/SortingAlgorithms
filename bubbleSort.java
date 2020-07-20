class bubbleSort {
  public static int[] bubbleSort(int[] inputArr) {
    //references:
    //https://en.wikipedia.org/wiki/Bubble_sort
    //zyBooks chapter 17

    int i, j, tempInt= 0;
    int length = inputArr.length;

    for( i = 0; i < length-1; i++) {
      for( j = 0; j < length-1-i; j++) {
        if(inputArr[j] > inputArr[j+1]) {
          tempInt = inputArr[j+1];
          inputArr[j+1] = inputArr[j];
          inputArr[j] = tempInt;
        }
      }
    }
    return inputArr;
  }
}
