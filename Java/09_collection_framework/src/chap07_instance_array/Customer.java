package chap07_instance_array;

import java.util.List;
import java.util.Map;

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
  public void addToCart(Map<String, Object> product) {
    if(cart == null) {
      JOptionPane.showMessageDialog(null, "카트를 먼저 준비하세요.");
      return;
    }
    cart.addProduct(product);
  }
  
  public void removeFromCart(int idx) {
    Map<String, Object> removed = cart.removeProduct(idx);
    if(removed != null) {
      JOptionPane.showMessageDialog(null, removed.get("name") + "제품이 Cart에서 제거되었습니다.");
    }
    
  }
  
  public String purchase() {
    if(cart == null) {
      JOptionPane.showMessageDialog(null, "카트가 없어서 구매할 수 없습니다.");
      return null;
    }
    List<Map<String, Object>> products = cart.getProducts();
    int count = cart.getProducts().size();
    if(count == 0) {
      JOptionPane.showMessageDialog(null, "카트에 담긴 상품이 없어서 구매할 수 없습니다.");
      return null;
    }
    String receipt = "================= 구디마트 영수증 =================\n";
    int total = 0;
    products = cart.getProducts();
    
    for(int i=0; i<count; i++) {
      Map<String, Object> product = products.get(i);
      int price = (int)product.get("price");
      String name = (String)product.get("name");
   
      
      if(total > money) {
        JOptionPane.showMessageDialog(null, "카트에 담긴 상품이 없어서 구매할 수 없습니다.");
        return null;
      }
      
      total += price;
      receipt += name + "    " + price + "원\n";
    }
    money -= total;
    return receipt + "총 금액: " + total + "원";
  }

}
