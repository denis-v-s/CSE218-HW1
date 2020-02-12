package data;

/**
* Book data type 
**/

public class Book {
  private Author[] authorList = new Author[3];
  private String isbn;
  private String title;
  private double price;
  
  public Book(Author[] authorList, String isbn, String title) {
    super();
    this.authorList = (Author[]) authorList.clone(); 
    this.isbn = isbn;
    this.title = title;
    this.price = this.generatePrice();
  }
  
  public Author[] getAuthorList() {
    return authorList;
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
    return "Title: " + title + ", Author's Last Name: " + authorList[0].getLastName();
  }
}
