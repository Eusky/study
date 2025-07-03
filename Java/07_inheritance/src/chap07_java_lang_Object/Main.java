package chap07_java_lang_Object;

public class Main {

  public static void main(String[] args) {
    
    Object car1 = new Car("123가 4567", "제네시스");
    
    // down-casting을 통해 carInfo() 메소드를 호출
    if(car1 instanceof Car) {
    ((Car)car1).carInfo();
    }
    
    // car1 인스턴스와 동일한 값을 가지는 car2 인스턴스 생성
    Object car2 = new Car("123가 4567", "레이");
    
    // override된 equals() 메소드 동작 확인
    System.out.println(car1.equals(car2));
    
    // override된 toString() 메소드 동작 확인
    System.out.println(car1); //------- toString() 메소드는 생략합니다.
    System.out.println(car2); //------- toString() 메소드는 생략합니다.
 
  }

}
