package data;

import java.io.*;
import java.nio.file.*;
import java.util.Arrays;
import java.util.stream.*;

/**
* Reads the files into arrays, then compiles them into one main array that's retured by getAllBooks() method 
**/
public class BookProvider {
  private Book[] books;
  private String[] firstNames;
  private String[] lastNames;
  private String[] isbnList;
  private String[] bookTitleList;
  
  public BookProvider() {
    init();
  }
  
  private void init() {
    Path dir = Paths.get("").toAbsolutePath().resolve("src/data/");
    Path firstNamesPath = dir.resolve("First_Names.txt");
    Path lastNamesPath = dir.resolve("Last_Names.txt");
    Path isbnPath = dir.resolve("textbook_isbns.txt");
    Path bookTitlesPath = dir.resolve("textbook_titles.txt");

    // initialize arrays that hold files content
    int countOfNames = 0;
    int countOfBooks = 0;
    
    try {
      countOfNames = (int) Files.lines(firstNamesPath).count();
      countOfBooks = (int) Files.lines(isbnPath).count();      
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
    
    books = new Book[countOfBooks];
    firstNames = new String[countOfNames];
    lastNames = new String[countOfNames];
    isbnList = new String[countOfBooks];
    bookTitleList = new String[countOfBooks];
    
    // push the actual file content into the respective arrays
    getFileContent(firstNamesPath, firstNames);
    getFileContent(lastNamesPath, lastNames);
    getFileContent(isbnPath, isbnList);
    getFileContent(bookTitlesPath, bookTitleList);
    
    // populate a list books
    for (int i = 0; i < bookTitleList.length; i++) {
      int authorCount = (int) (1 + Math.random() * 3);
      Author[] authorList = new Author[authorCount];
      
      // generate between 1 and 3 authors
      IntStream.range(0, authorCount).forEach(j -> {
        int nameIndex = (int) (Math.random() * (firstNames.length));
        authorList[j] = new Author(firstNames[nameIndex], lastNames[nameIndex]); 
      });
      
      books[i] = new Book(authorList, isbnList[i], bookTitleList[i]);
    }
  }
  
  public Book[] getAllBooks() {
    return Arrays.copyOf(books, books.length);
  }
  
  private void getFileContent(Path fileName, String[] data) {
    try (FileReader fr = new FileReader(fileName.toString()); BufferedReader reader = new BufferedReader(fr)) {
      IntStream.range(0, data.length).forEach(i -> {
        try {
          data[i] = reader.readLine();
        } catch (IOException e) {
          e.printStackTrace();
        }
      });
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
