package data;

import java.util.*;

import sorting.*;

public class App {
  // gets the difference, and converts to seconds
  private static double getRunTimeInSeconds(double start, double end) {
    return (double) (end - start) / 1_000_000_000;
  }

  // @return amount of time it took to sort
  private static double sort(Sorter s, Comparator<Book> c, Book[] items, int topN) {
    System.out.println("before sort: ");
    
    Arrays.stream(items).limit(topN).forEach(System.out::println);
    
    double start = System.nanoTime();
    s.sort(items, c);
    double end = System.nanoTime();
    double sortTime = getRunTimeInSeconds(start, end);
    System.out.println("\r\nafter sort (" + sortTime + " seconds to sort " + items.length + " items): ");
    
    Arrays.stream(items).limit(topN).forEach(System.out::println);
    
    System.out.println();
    
    return sortTime;
  }
  
  public static void main(String[] args) {
    int topN = 10; // number of books to display
    
    BookProvider bookProvider = new BookProvider();
    Book[] booksByTitle = bookProvider.getAllBooks();
    Book[] booksByName = bookProvider.getAllBooks();
    
    // sorting options
    Comparator<Book> sortByTitle = (a, b) -> a.getBookTitle().compareTo(b.getBookTitle());
    Comparator<Book> sortByLastName = (a, b) -> 
      a.getAuthorList()[0].getLastName().compareTo(
      b.getAuthorList()[0].getLastName()
    );
    
    // ** BUBBLE SORT ** //
    System.out.println("BUBBLE SORT");
    double bubbleSortTime = sort(new BubbleSort(), sortByTitle, booksByTitle, topN);
    
    // ** INSERTION SORT ** //
    System.out.println("INSERTION SORT");
    double insertionSortTime = sort(new InsertionSort(), sortByLastName, booksByName, topN);
    
    // runtime comparison
    System.out.println("Bubble sort: " + bubbleSortTime);
    System.out.println("Insertion sort: " + insertionSortTime);
    double delta = bubbleSortTime - insertionSortTime;
    System.out.printf("Bubble sort was %f seconds %s at sorting %d items", 
        Math.abs(delta), 
        (delta > 0) ? "slower" : "faster",
        booksByTitle.length
    );
  }
}
