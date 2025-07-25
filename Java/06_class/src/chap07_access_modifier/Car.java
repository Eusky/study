package chap07_access_modifier;

public class Car {
  
  /*
   * Access Modifier(접근 제어자)
   * 
   * 1. 클래스 내의 멤버(필드, 메소드)에 접근할 수 있는 권한을 의미합니다.
   * 2. 종류
   *  1) public    : 누구나 접근할 수 있습니다.
   *  2) protected : 동일 패키지에 있거나 상속 관계인 경우 접근할 수 있습니다.
   *  3) default   : 동일 패키지에 있으면 접근할 수 있습니다. (default 키워드는 존재하지 않습니다. package 권한이라고도 합니다. Access Modifier가 없는 경우 default 권한을 가집니다.) 
   *  4) private   : 클래스 내부에서만 접근할 수 있습니다.
   * 3. 멤버의 권한
   *  1) 필드   : private (정보 은닉)
   *  2) 메소드 : public
   *  3) 생성자 : public
   *  
   */
  
  // 필드
  private String model;
  private int price;
  private Brand brand;
  
  
  // 생성자
  public Car() {
    this("E350", 8000, new Brand());
  }
  
  public Car(String model, int price, Brand brand) {
    this.model = model;
    this.price = price;
    this.brand = brand;
  }
  
  public Car(String model, int price, String name, String nation) {
    this(model, price, new Brand(name, nation));
  }
  
  // 메소드
  public void printInfo() {
    System.out.println(model + ", " + price);
    brand.printInfo();
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public Brand getBrand() {
    return brand;
  }

  public void setBrand(Brand brand) {
    this.brand = brand;
  }
}
