package chap05_field;

public class Car {
  
  /*
   * 필드(field)
   * 1. 객체가 가지는 값입니다.
   * 2. 클래스에서 선언한 변수입니다. 일반 지역변수와 구분해서 필드라고 부릅니다.
   * 3. 클래스에 포함된 모든 메소드는 필드를 사용할 수 있습니다. 
   * 4. 일반 지역 변수와 달리 선언만 하면 자동으로 초기화됩니다. (0, false, null 등)
   */

  String model; //--------- String model = null;
  int price; //--------- int price = 0;
  
  void setInfo(String model, int price) {
    // this
    // setInfo 메소드를 호출하는 객체(인스턴스)를 의미합니다. (참조값)
    // 필드 이름과 매개변수 이름이 동일할 때 구별하기 위해 this를 사용합니다.
    
    this.model = model;
    this.price = price;
  }
  
  void printInfo() {
    System.out.println(model + " " + price);
  }
}
