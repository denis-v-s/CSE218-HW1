package sorting;

import java.util.*;

/**
* Bubble Sort implementation 
**/

public class BubbleSort implements Sorter {
  
  public <T> void sort(List<T> items, Comparator<T> c) {
    for (int i = items.size() - 1; i > 0; i--) {
      for (int j = 1; j <= i; j++) {
        if (c.compare(items.get(j), items.get(j - 1)) < 0) {
          swap(items, j, j-1);
        }
      }
    }
  }
  
  private static <T> void swap(List<T> items, int a, int b) {
    T temp = items.get(a);
    items.set(a, items.get(b));
    items.set(b, temp);
  }
}
