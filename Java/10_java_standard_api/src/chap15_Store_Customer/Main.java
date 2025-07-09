package chap15_Store_Customer;

public class Main {

  public static void main(String[] args) {
    
    //----- 한 명의 고객을 생성합니다.
    Customer customer = new Customer(0, 100);
    
    //----- 상품을 판매할 두 개의 상점을 생성합니다.
    Store store1 = new Store(10, 1.9, 100);
    Store store2 = new Store(10, 2.9, 100);
    
    //----- 첫 번째 상점에서 상품을 구매합니다. 
    customer.purchase(store1, 5, 10);
    
    //----- 두 번째 상점에서 상품을 구매합니다.
    customer.purchase(store2, 5, 15);
    
    
    //----- 모든 상점의 정보와 고객의 정보를 출력합니다.
    System.out.println(store1.toString());
    System.out.println(store2.toString());
    System.out.println(customer.toString());

  }

}
