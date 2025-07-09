package chap8_store_customer;

import java.util.Map;

/**
 * 단일 상품을 판매하는 상점(Store) 클래스입니다.
 * 
 * 판매 상품의 개수를 저장할 int count 필드를 선언합니다.
 * 해당 상품의 가격을 저장할 double price 필드를 선언합니다.
 * 상점이 가지고 있는 자본금을 저장할 double money 필드를 선언합니다.
 * 
 * 모든 필드 정보를 전달 받는 생성자를 생성합니다.
 * 
 * 모든 필드에 대해서 Getter/Setter를 생성합니다.
 * 
 * 판매 메소드를 생성합니다. 판매 메소드의 세부 내용은 Store 클래스 본문을 참고하세요.
 */
public class Store {
  
  // 필드
  private int count; //--------- 상품 갯수
  private double money; //------ 상점 돈
  private double price; //------ 상품 가격

  // 생성자
  public Store(int count, double price, double money) {
    super();
    this.count = count;
    this.price = price;
    this.money = money;
  }

  // Getter, Setter
  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public double getMoney() {
    return money;
  }

  public void setMoney(double money) {
    this.money = money;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  /**
   * 판매 메소드입니다.
   * 구매를 원하는 상품의 개수가 상점이 보유한 상품의 개수보다 많으면 판매를 할 수 없습니다.
   * 고객이 낸 돈이 상품의 가격보다 부족하면 판매를 할 수 없습니다.
   * 
   * @param money 상품 구매를 위해서 고객이 상점에 낸 돈(money)입니다.
   * @param count 구매를 원하는 상품의 개수(count)입니다. 
   * @return 판매한 상품의 개수와 잔돈을 저장하는 Map 타입의 객체입니다.
   */
  public Map<String, Object> sell(double money, int count) {
    if(this.count < count) {
      System.out.println("판매 불가. 현재 상품 재고: " + this.count + "개 입니다.");
      return null;
    }
    if(price * count > money) {
      System.out.println("판매 불가. 전체 상품 가격: " + price * count + "원 입니다.");
      return null;
    }
    // 판매하기
    this.money += price * count;
    this.count -= count;
    
    // 고객에게 반환할 Map 객체(상품갯수 + 잔돈)
    return Map.of("count", count, "change", money - (price * count));
  }

  @Override
  public String toString() {
    return "Store [count=" + count + ", money=" + money + ", price=" + price + "]";
  }
  
}
