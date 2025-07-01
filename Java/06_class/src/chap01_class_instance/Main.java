package chap01_class_instance;

public class Main {

  public static void main(String[] args) {
    
    // 클래스 Book 타입의 객체 선언(참조 변수 선언)
    Book book1;
    
    // book1 객체 생성(인스턴스)
    book1 = new Book();
    
    // book1 객체 정보 확인
    System.out.println(book1);
    
    // 클래스 Book 타입의 객체 선언 및 생성과 확인
    Book book2 = new Book();
    System.out.println(book2);
  

  }

}
