package chap04_instance_array;

import javax.swing.JOptionPane;

public class Cart {
  // 필드
  private Product[] products; // Product 배열 선언(배열의 생성이 아직 필요합니다)
  private int count; // products 배열에 저장된 Product 개수
  private final int LIMIT = 100; // products 배열의 최대 길이 (final 상수: 값을 바꿀 수 없습니다. 반드시 초기화가 필요합니다. 관례상 대문자로 적습니다.)
  
  // 생성자
  public Cart() {
    // new Cart() 실행 시 products 배열이 생성됩니다. 
    products = new Product[LIMIT];
  }

  // 메소드

  public Product[] getProducts() {
    return products;
  }

  public void setProducts(Product[] products) {
    this.products = products;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }
  
  public void addProduct(Product product) {
    
    
    try {
      // 예외처리
      if(product == null) {
        throw new RuntimeException("전달된 상품이 없습니다");
      }
      if(count == LIMIT) {
        throw new RuntimeException("더 이상 상품을 담을 수 없습니다.");
      }
      products[count++] = product;
      
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
  
  public Product removeProduct(int idx) {
    
    Product removed = null;
    
    try {
      if(count == 0) {
        throw new RuntimeException("카트가 비어있습니다.");
      }
      
      if(idx < 0 || idx >= count) {
        throw new RuntimeException("더이상 카트에 담을 수 없습니다.");
      }
      
      System.arraycopy(products, idx + 1, products, idx, count - idx - 1);
      products[--count] = null;
      
      removed = products[idx];
      
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    
    return removed;
  }
  
  
}
