package pkg_practice;

public class Book {
  
  String title;
  String author;
  int price;
  
  // 생성자
  Book(String title, String author, int price) {
    this.title = title;
    this.author = author;
    this.price = price;
  }
  
  // 메서드
  void printInfo() {
    if (price <= 0) {
      System.out.println("가격 오류");
      return;
    }
    System.out.println("제목: " + title + "저자: " + author + "가격: " + price);
    
  }
  
  @Override
  public String toString() {
    return "제목: " + title + ", 저자: " + author + ", 가격: " + price + "원";
  }

}
