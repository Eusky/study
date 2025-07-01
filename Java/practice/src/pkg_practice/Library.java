package pkg_practice;


public class Library {
  
  // 필드
  Book[] books = new Book[100];
  int count = 0;
  
  // 메서드
  void addBook(Book book) {
    books[count++] = book;
  }
  void printAllBooks() {
    
    System.out.println("[전체 도서 목록]");
    
    for(int i=0; i<books.length; i++) {
      if(books[i] != null) {
      System.out.println(books[i]);
      }
    }
    System.out.println();
  }
  
  void printAllExpensiveBooks() {
    System.out.println("[3만원 이상 도서 목록]");
    for(int i=0; i<books.length; i++) {
      if(books[i] != null && books[i].price >= 30000) {
      System.out.println(books[i]);
      }
    }
  }
 
}
