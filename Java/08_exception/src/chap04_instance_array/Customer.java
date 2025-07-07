package chap04_instance_array;

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
    // 마이너스 money는 예외 발생 후 예외처리
    
    try {
      if(money < 0) {
        throw new RuntimeException("금액은 음수가 될 수 없습니다.");
      }
      this.money = money;
      
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public Cart getCart() {
    return cart;
  }

  public void setCart(Cart cart) {
    this.cart = cart;
  }
  
  // 메소드
  public void addToCart(Product product) {
    
    try {
      if(cart == null) {
        throw new RuntimeException("카트를 먼저 준비하세요.");
      }
      cart.addProduct(product);
      
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
  
  public void removeFromCart(int idx) {
    Product removed = cart.removeProduct(idx);
    if(removed != null) {
      JOptionPane.showMessageDialog(null, removed.getName() + "제품이 Cart에서 제거되었습니다.");
    }
    
  }
  
  public String purchase() {
    // 예외 발생 후 예외 처리
    String receipt = null;
    
    try {
      if(cart == null) {
        throw new RuntimeException("카트가 없어서 구매할 수 없습니다.");
      }
      int count = cart.getCount();
      if(count == 0) {
        throw new RuntimeException("카트에 담긴 상품이 없어서 구매할 수 없습니다.");
      }
      
      receipt = "================= 구디마트 영수증 =================\n";
      
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
          receipt = null;
          throw new RuntimeException("돈이 부족해서 구매할 수 없습니다.");
        }
        
        total += price;
        receipt += formattedInfo;
      }
      money -= total;
      receipt = receipt + "총 금액: " + total + "원";
      
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
    return receipt;
  }

}
