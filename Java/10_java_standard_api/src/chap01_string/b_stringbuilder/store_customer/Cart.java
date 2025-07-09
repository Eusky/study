package chap01_string.b_stringbuilder.store_customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

public class Cart {
  // 필드
  private List<Map<String, Object>> products;   
  
  // 생성자
  public Cart() {
    // new Cart() 실행 시 products 배열이 생성됩니다. 
    products = new ArrayList<Map<String, Object>>();
  }

  // 메소드
  public List<Map<String, Object>> getProducts() {
    return products;
  }

  public void setProducts(List<Map<String, Object>> products) {
    this.products = products;
  }

  public void addProduct(Map<String, Object> product) {
    if(product == null) {
      JOptionPane.showMessageDialog(null, "전달된 상품이 없습니다");
      return;
    }
    
    products.add(product);
  }
  
  public Map<String, Object> removeProduct(int idx) {
    int count = products.size();
    if(count == 0) {
      JOptionPane.showMessageDialog(null, "카트가 비어있습니다.");
      return null;
    }
    
    if(idx < 0 || idx >= count) {
      JOptionPane.showMessageDialog(null, "더이상 카트에 담을 수 없습니다.");
      return null;
    }
    
    return products.remove(idx);
    
  }
  
  
}
