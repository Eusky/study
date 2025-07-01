package chap07_access_modifier;

/*
 * import
 * 
 * 1. 다른 패키지에 있는 클래스, 인터페이스, 라이브러리 등을 현재 소스 파일에서 사용할 수 있도록 불러오는 과정.
 * 2. 동일한 패키지에 있거나, java.lang 패키지에 있으면 import를 하지 않습니다.
 * 3. 다른 패키지에 있거나, java.lang 패키지에 없는 것들은 import를 해야 합니다.
 * 4. import 사용 예시
 *    1) 특정 클래스 import 하기
 *    import java.util.Arrays;
 *    2) 특정 패키지 전체 import 하기
 *    import java.util.*;
 *    3) 이클립스의 import 정리 단축키
 *    Ctrl + Shift + O(대문자 O)
 */

/*
 * 캡슐화(Encapsulation)
 * 
 * 데이터(필드)와 기능(메소드)을 하나의 클래스로 묶고,
 * 데이터를 외부에서 직접 볼 수 없게 은닉하여 보호하고
 * 필요한 기능만 외부에 공개합니다.
 */

public class Main {

  public static void main(String[] args) {
    
    Car car1 = new Car();
    Car car2 = new Car("X6", 12000, new Brand("Hyundai", "Korea"));
    Car car3 = new Car("model3", 9000, "Tesla", "USA");
    
    car1.printInfo();
    car2.printInfo();
    car3.printInfo();
    
    // Getter는 필드값을 확인할 때 사용합니다.
    System.out.println(car1.getModel());
    System.out.println(car1.getPrice());
    System.out.println(car1.getBrand().getName());
    System.out.println(car1.getBrand().getNation());
    
    
    // Setter는 필드값을 수정할 때 사용합니다.
    
    car3.setModel("Sorento");
    car3.setPrice(4000);
    car3.setBrand(new Brand("Kia", "Korea"));
    car3.printInfo();
    
    car2.setModel("Avanter");
    car2.setPrice(5000);
    car2.getBrand().setName("Kia");
    car2.getBrand().setNation("Korea");
  }

}
