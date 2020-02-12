package sorting;

import java.util.*;

public interface Sorter {
  <T> void sort(T[] items, Comparator<T> c);
}
