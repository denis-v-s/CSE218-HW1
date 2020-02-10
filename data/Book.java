package data;
import java.util.*;

/**
* Book data type 
**/

public class Book {
  private ArrayList<Author> authorList;
  private String isbn;
  private String title;
  private double price;
  
  public Book(ArrayList<Author> authorList, String isbn, String title) {
    super();
    this.authorList = new ArrayList<>(authorList); 
    this.isbn = isbn;
    this.title = title;
    this.price = this.generatePrice();
  }
  
  public ArrayList<Author> getAuthorList() {
    return new ArrayList<>(this.authorList);
  }
  
  public String getIsbn() {
    return isbn;
  }
  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }
  
  public String getBookTitle() {
    return title;
  }
  public void setBookTitle(String bookTitle) {
    this.title = bookTitle;
  }
  
  private double generatePrice() {
    // set random price, between $0 and $99.9
    return Math.random() * (99.9 + 1);
  }
  
  public double getPrice() {
    return this.price;
  }
  
  public String toString() {
    return "Title: " + title + ", Author's Last Name: " + authorList.get(0).getLastName();
  }
  
}
