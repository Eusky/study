package chap05_instance_array_throws;

public class Product {
  
  // 필드
  private String name;
  private int price;
  
  // 생성자
  public Product(String name, int price) {
    this.name = name;
    this.price = price;
  }

  // Getter, Setter
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) { // throws RuntimeException 생략 
    // 예외 발생 후 예외 회피
    if(price < 0) {
      throw new RuntimeException(price + "원은 잘못된 가격입니다.");
    }
    this.price = price;
  }
  
  // 메소드
  

}
