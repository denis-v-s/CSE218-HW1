package sorting;

import java.util.*;

public interface Sorter {
  <T> void sort(List<T> items, Comparator<T> c);
}
