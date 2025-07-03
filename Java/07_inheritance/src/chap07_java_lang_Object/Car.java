package chap07_java_lang_Object;

import java.util.Objects;

/*
 * java.lang.Object 클래스
 * 
 * 1. 자바의 모든 클래스의 최상위 슈퍼 클래스입니다.
 * 2. 별도의 슈퍼클래스 명시가 없는 클래스들은(extends가 없는 클래스) 모두 java.lang.Object 클래스를 슈퍼 클래스로 가집니다.
 * 3. 모든 객체(인스턴스)들은 java.lang.Object 타입으로 업캐스팅 할 수 있습니다. (만능 타입입니다.)
 *    단, java.lang.Object 타입으로 업캐스팅된 객체는 오직 java.lang.Object 클래스의 멤버만 호출할 수 있으므로 
 *    반드시 다운캐스팅을 이용해서 객체 자신의 메소드를 호출해야 합니다. 
 */

public class Car {
  
  // 생성자
  public Car(String carNo, String model) {
    super(); //--------- java.lang.Object 클래스의 생성자를 호출합니다. 디폴트 생성자의 호출이므로 생략 가능합니다.
    this.carNo = carNo;
    this.model = model;
  }
  // 필드
  private String carNo;
  private String model;
  
  public String getCarNo() {
    return carNo;
  }
  public void setCarNo(String carNo) {
    this.carNo = carNo;
  }
  public String getModel() {
    return model;
  }
  public void setModel(String model) {
    this.model = model;
  }
  // 메소드
  public void carInfo() {
    System.out.println("차량번호: " + carNo);
    System.out.println("차량모델: " + model);
  }
//  @Override
//  public boolean equals(Object car) {
//    // 두 객체의 carNo가 일치하면 true 아니면 false를 반환합니다.
//      if(((Car)car).getCarNo() == ((Car)this).getCarNo()) {
//        return true;
//      }
//  }
//  @Override 
//  public String toString() {
//    // "모델명, 자동차번호" 형식의 문자열을 반환합니다.
//  }
  @Override
  public int hashCode() {
    return Objects.hash(carNo);
  }
  //---------- equals() 메소드 오버라이드
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Car other = (Car) obj;
    return Objects.equals(carNo, other.carNo);
  }
//---------- toString() 메소드 오버라이드
  @Override
  public String toString() {
    return "Car [carNo=" + carNo + ", model=" + model + "]";
  }

}
