package sorting;

import java.util.*;

/**
* Insertion Sort implementation 
**/

public class InsertionSort implements Sorter {
  public <T> void sort(List<T> items, Comparator<T> c) {
    for (int i = 1; i < items.size(); i++) {
      T cur = items.get(i);
      int j = i - 1;
      
      while (j >= 0 && c.compare(items.get(j), cur) > 0) {
        items.set(j + 1, items.get(j));
        j--;
      }
      
      items.set(j + 1, cur);
    }
  }
}