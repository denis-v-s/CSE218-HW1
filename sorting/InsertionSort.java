package sorting;

import java.util.*;

/**
* Insertion Sort implementation 
**/

public class InsertionSort implements Sorter {
  public <T> void sort(T[] items, Comparator<T> c) {
    for (int i = 1; i < items.length; i++) {
      T cur = items[i];
      int j = i - 1;
      
      while (j >= 0 && c.compare(items[j], cur) > 0) {
        items[j + 1] = items[j];
        j--;
      }
      
      items[j + 1] = cur;
    }
  }
}