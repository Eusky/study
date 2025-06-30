package chap06_constructor;

/*
 * 생성자(Constructor)
 * 
 * 1. 객체(인스턴스)룰 생성할 때 호출하는 특별한 메소드입니다.
 * 2. 오직 객체(인스턴스)를 생성할때만 호출할 수 있움. '
 * 3. 객체 생성 키워드 new 뒤에서 생성자를 호출합니다.
 * 4. 주요 특징
 *   1)생성자의 일므은 클래스의 이름과 반ㄷ시 같아야 합니다.
 *   2) 일반 메소드와 달리 반환타입이 존재하지 않습니다.
 *   3. 일반 메소드처럼 메소드 오버로딩이 가능합니다.
 */

/*
 * 디폴트 생성자(Default Constructor)
 * 1. 매개변수가 없는 생성자입니다.
 * 2. 자동 생성
 *  클래스에 생성자를 하나도 정의하지 않으면, 자바 컴파일러는 매개변수가 없고, 
 *  본문이 비어 있는 디폴트 생성자를 자동으로 생성합니다.
 *  3. 직접 정의
 *  클래스에 생성자를 한 이상 생성하면, 디폴트 생성자는 더 이상 자동으로 생성되지 않습니다.
 */

public class Car {
  
  // 클래스를 정의할 때 "필드" > "생성자" > "메소드" 순으로 정의합니다.
  
  // 필드
  String model;
  int price;
  Brand brand; //------- Brand brand = null;
  
  // 디폴트 생성자
  Car() {
    System.out.println("생성자 Car() 호출되었습니다.");
  }
  
  // 일반 생성자 1
  Car(String model) {
    this.model = model;
    
  }
  // 일반 생성자 2
  Car(int price) {
    this.price = price;
  }
  
  // 일반 생성자 3
  Car(String model, int price) {
    this.model = model;
    this.price = price;
  } 
  
  // 일반 생성자 4
  Car(String model, int price, Brand brand) {
    this(model, price);
    this.brand = brand;
  }
  
  
  // 메소드
  void printInfo() {
    if(brand != null) {
      brand.printInfo();
    }
    System.out.println(model + " " + price);
  }
  
}
