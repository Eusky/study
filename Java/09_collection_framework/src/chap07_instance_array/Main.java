package chap07_instance_array;

import java.util.Map;

public class Main {

  public static void main(String[] args) {
    // 제품 진열하기
    Map<String, Object> product1 = Map.of("name", "양파1.5kg", "price", 3000);
    Map<String, Object> product2 = Map.of("name", "한돈앞다리1kg", "price", 15000);
    Map<String, Object> product3 = Map.of("name", "고등어1손", "price", 5000);
    Map<String, Object> product4 = Map.of("name", "블랙앵거스살치살", "price", 20000);
    Map<String, Object> product5 = Map.of("name", "꼬마돈가스", "price", 9000);
  
    
    // 카트 진열하기
    Cart cart1 = new Cart();
    
    // 고객 입장
    Customer customer1 = new Customer(50000);
    
    // 고객이 카트를 취득
    customer1.setCart(cart1);
    
    // 쇼핑
    customer1.addToCart(product2);
    customer1.addToCart(product3);
    customer1.addToCart(product4);
    customer1.removeFromCart(0);
    
    // 구매
    String receipt = customer1.purchase();
    
    // 구매내역 확인
    if(receipt != null) {
      System.out.println(receipt); // 구매 Product 목록 + 총 구매금액
      System.out.println("남은 돈: " + customer1.getMoney());
    }
    
  }

}
