package sorting;

import java.util.*;

/**
* Bubble Sort implementation 
**/

public class BubbleSort implements Sorter {
  
  public <T> void sort(T[] items, Comparator<T> c) {
    for (int i = items.length - 1; i > 0; i--) {
      for (int j = 1; j <= i; j++) {
        if (c.compare(items[j], items[j - 1]) < 0) {
          swap(items, j, j-1);
        }
      }
    }
  }
  
  private static <T> void swap(T[] items, int a, int b) {
    T temp = items[a];
    items[a] = items[b];
    items[b] = temp;
  }
}
