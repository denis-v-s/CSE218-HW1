package data;

import java.nio.file.*;
import java.util.*;

/**
* Reads the files into arrays, then compiles them into one main array that's retured by getAllBooks() method 
**/
public class BookProvider {
  private ArrayList<Book> books = new ArrayList<>();
  private ArrayList<String> firstNames;
  private ArrayList<String> lastNames;
  private ArrayList<String> isbnList;
  private ArrayList<String> bookTitleList;
  
  public BookProvider() {
    init();
  }
  
  private void init() {
    Path dir = Paths.get("").toAbsolutePath().resolve("src/data/");
    firstNames = getFileContent(dir.resolve("First_Names.txt"));
    lastNames = getFileContent(dir.resolve("Last_Names.txt"));
    isbnList = getFileContent(dir.resolve("textbook_isbns.txt"));
    bookTitleList = getFileContent(dir.resolve("textbook_titles.txt"));
    
    for (int i = 0; i < bookTitleList.size(); i++) {
      int authorCount = (int) (1 + Math.random() * 3);
      ArrayList<Author> authorList = new ArrayList<>();
      
      // generate between 1 and 3 authors
      while (authorCount > 0) {
        int nameIndex = (int) (Math.random() * (firstNames.size()));
        authorList.add(new Author(firstNames.get(nameIndex), lastNames.get(nameIndex)));
        authorCount--;
      }
      
      books.add(new Book(authorList, isbnList.get(i), bookTitleList.get(i)));
    }
  }
  
  public ArrayList<Book> getAllBooks() {
    return new ArrayList<>(this.books);
  }
  
  private ArrayList<String> getFileContent(Path fileName) {
    ArrayList<String> data = null;
    try {
      data = new ArrayList<>(Files.readAllLines(fileName));      
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
    
    return data;
  }
}
