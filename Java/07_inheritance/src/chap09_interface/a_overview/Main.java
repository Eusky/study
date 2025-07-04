package chap09_interface.a_overview;

public class Main {

  public static void main(String[] args) {
    
    // 인터페이스를 구현클래스 객체의 타입으로 사용합니다.
    Animal lion = new Lion();
    
    lion.move();
    lion.eat();
    Animal.breath();

  }

}
