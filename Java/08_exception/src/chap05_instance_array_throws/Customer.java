package chap05_instance_array_throws;

import javax.swing.JOptionPane;

public class Customer {
  
  // 필드
  private int money;
  private Cart cart;
  
  // 생성자
  public Customer(int money) {
    this.money = money;
  }

  // Getter, Setter
  public int getMoney() {
    return money;
  }

  public void setMoney(int money) {
    this.money = money;
  }

  public Cart getCart() {
    return cart;
  }

  public void setCart(Cart cart) {
    this.cart = cart;
  }
  
  // 메소드
  public void addToCart(Product product) {
    // 예외 발생 후 예외 회피 
    if(cart == null) {
      throw new RuntimeException("카트를 먼저 준비하세요.");
    }
    cart.addProduct(product); // Cart의 addProduct()이 던진 예외를 다시 회피합니다.
  }
  
  public void removeFromCart(int idx) {
    Product removed = cart.removeProduct(idx); // Cart의 removeProduct()이 던진 예외를 다시 회피합니다.
    if(removed != null) {
      System.out.println(removed.getName() + "제품이 Cart에서 제거되었습니다.");
    }
    
  }
  
  public String purchase() {
    if(cart == null) {
      throw new RuntimeException("카트가 없어서 구매할 수 없습니다.");
    }
    int count = cart.getCount();
    if(count == 0) {
      throw new RuntimeException("카트에 담긴 상품이 없어서 구매할 수 없습니다.");
    }
    String receipt = "================= 구디마트 영수증 =================\n";
    int total = 0;
    Product[] products = cart.getProducts();
    
    for(int i=0; i<count; i++) {
      Product product = products[i];
      int price = product.getPrice();
      String name = product.getName();
      String formattedInfo = String.format("%-30s%10d\n", name, price);
      // %30s : 문자열을 30자리 고정폭으로 작성, 마이너스(-) 기호는 왼쪽 정렬을 의미
      // %10d : 정수를 10자리 고정폭으로 작성, 마이너스(-) 기호가 없으면 오른쪽 정렬을 의미
      
      if(total > money) {
        throw new RuntimeException("돈이 부족해서 구매할 수 없습니다.");
      }
      
      total += price;
      receipt += formattedInfo;
    }
    money -= total;
    return receipt + "총 금액: " + total + "원";
  }

}
