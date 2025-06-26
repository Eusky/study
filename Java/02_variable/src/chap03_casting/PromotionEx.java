package chap03_casting;

public class PromotionEx {

  public static void main(String[] args) {
    /*
     *  Promotion
     *  
     *  1. 데이터 타입 변환의 한 종류입니다.
     *  2. 별도 코드 없이 자동으로 수행하는 타입 변환입니다.
     *  3. 작은 데이터 타입을 큰 데이터 타입으로 자동 변환하는 과정합니다. (크기가 아닌 데이터 표현 범위가 기준)
     *  4. 타입 변환시 데이터 손실이 발생하지 않습니다.
     *  
     */

    int i = 10;
    long l = i; // Promotion (자동 변환)
    double d = l; // Promotion (자동 변환)

    System.out.println(i);
    System.out.println(l);
    System.out.println(d);
  }

}
