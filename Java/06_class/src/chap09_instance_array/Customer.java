package chap09_instance_array;

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
    if(cart == null) {
      JOptionPane.showMessageDialog(null, "카트를 먼저 준비하세요.");
      return;
    }
    cart.addProduct(product);
  }
  
  public void removeFromCart(int idx) {
    Product removed = cart.removeProduct(idx);
    if(removed != null) {
      JOptionPane.showMessageDialog(null, removed.getName() + "제품이 Cart에서 제거되었습니다.");
    }
    
  }
  
  public String purchase() {
    if(cart == null) {
      JOptionPane.showMessageDialog(null, "카트가 없어서 구매할 수 없습니다.");
      return null;
    }
    int count = cart.getCount();
    if(count == 0) {
      JOptionPane.showMessageDialog(null, "카트에 담긴 상품이 없어서 구매할 수 없습니다.");
      return null;
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
        JOptionPane.showMessageDialog(null, "카트에 담긴 상품이 없어서 구매할 수 없습니다.");
        return null;
      }
      
      total += price;
      receipt += formattedInfo;
    }
    money -= total;
    return receipt + "총 금액: " + total + "원";
  }

}
