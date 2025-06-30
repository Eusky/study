package pkg_practice;

public class Main {
  
  public static void main(String[] args) {
    
    
    Library library = new Library();
    
    Book book1 = new Book("자바의 정석", "남궁성", 30000);
    Book book2 = new Book("혼자 공부하는 자바", "신용권", 28000);
    Book book3 = new Book("자바섬 놀러가고 싶다", "박철수", 54000);
    Book book4 = new Book("세계요리백과", "이재명", 34000);
    Book book5 = new Book("러브버그 퇴치법", "존 스미스", 24000);
    
    library.addBook(book1);
    library.addBook(book2);
    library.addBook(book3);
    library.addBook(book4);
    library.addBook(book5);
    
    library.printAllBooks();
    library.printAllExpensiveBooks();
   
  }

}
