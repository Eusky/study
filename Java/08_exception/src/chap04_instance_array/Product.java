package chap04_instance_array;

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

  public void setPrice(int price) {
    // 가격을 음수로 설정하면 예외가 발생합니다.
    try {
      if(price < 0) {
        throw new RuntimeException(price + "원은 잘못된 가격입니다.");
      }
      this.price = price;
    }
    catch(RuntimeException e) {
      System.out.println(e.getMessage());
    }
    
  }
  

  

}
