package chap04_instance_array;

import javax.swing.JOptionPane;

public class Main {

  public static void main(String[] args) {
    // 제품 진열하기
    Product product1 = new Product("양파1.5kg", 3000);
    Product product2 = new Product("고등어1손", 5000);
    Product product3 = new Product("한돈앞다리1kg", 15000);
    Product product4 = new Product("블랙앵거스살치살500g", 20000);
    Product product5 = new Product("꼬마돈까스", 9000);
    
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
//    customer1.removeFromCart(0);
    
    // 구매
    String receipt = customer1.purchase();
    
    // 구매내역 확인
    if(receipt != null) {
      System.out.println(receipt); // 구매 Product 목록 + 총 구매금액
      System.out.println("남은 돈: " + customer1.getMoney());
    }
    
  }

}
